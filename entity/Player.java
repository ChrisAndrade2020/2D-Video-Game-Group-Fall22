package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
// import object.ObjectDoorOpen;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public int screenX;
    public int screenY;

    private BufferedImage[] pi;
    private BufferedImage[] pu;
    private BufferedImage[] pd;
    private BufferedImage[] pl;
    private BufferedImage[] pr;

    private long lastDirectionInputTime;
    private boolean idling;
    private boolean resetDirection;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.playerSize / 2) - 2;
        screenY = gp.screenHeight / 2 - (gp.playerSize - 48);

        solidArea = new Rectangle(); // (60, 96, gp.playerSize - 120, gp.playerSize - 120);
        solidArea.x = 61;
        solidArea.y = 96;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        solidArea.width = 24;
        solidArea.height = 24;

        setDefaultValues();
        getPlayerImage();

        lastDirectionInputTime = System.nanoTime();

        idling = false;
        resetDirection = false;

    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 6;
        worldY = gp.tileSize * 92;
        speed = 4;
        direction = "idle";

    }

    public void getPlayerImage() {

        // Initialize arrays
        pi = new BufferedImage[6];
        pu = new BufferedImage[6];
        pd = new BufferedImage[6];
        pl = new BufferedImage[6];
        pr = new BufferedImage[6];

        for (int i = 0; i < 6; i++) {
            pi[i] = setup("pi_" + (i + 1));
            pu[i] = setup("pu_" + (i + 1));
            pd[i] = setup("pd_" + (i + 1));
            pl[i] = setup("pl_" + (i + 1));
            pr[i] = setup("pr_" + (i + 1));
        }
    }

    public void updateSpriteCounter() {
        spriteCounter++;

        if (spriteCounter > 6) {
            spriteNum = (spriteNum % 6) + 1;
            spriteCounter = 0;
        }
    }

    public BufferedImage setup(String imageName) {
        UtilityTool tool = new UtilityTool();
        BufferedImage image = null;

        try {
            BufferedImage originalImage = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/" + imageName + ".png"));
            image = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            image.getGraphics().drawImage(originalImage, 0, 0, null);
            image = tool.scaledImage(image, gp.playerSize, gp.playerSize);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public void update() {

        // Checks tile Collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        // Checks object Collision
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);

        boolean keyPressed = keyH.up || keyH.down || keyH.left || keyH.right;

        if (keyPressed) {

            lastDirectionInputTime = System.nanoTime();
            idling = false;
            resetDirection = false;

            if (keyH.up) {
                direction = "up";
                collisionOn = false;
                gp.cChecker.checkTile(this);
                gp.cChecker.checkObject(this, true);
                if (!collisionOn) {
                    worldY -= speed;
                }
            }
            if (keyH.down) {
                direction = "down";
                collisionOn = false;
                gp.cChecker.checkTile(this);
                gp.cChecker.checkObject(this, true);
                if (!collisionOn) {
                    worldY += speed;
                }
            }
            if (keyH.left) {
                direction = "left";
                collisionOn = false;
                gp.cChecker.checkTile(this);
                gp.cChecker.checkObject(this, true);
                if (!collisionOn) {
                    worldX -= speed;
                }
            }
            if (keyH.right) {
                direction = "right";
                collisionOn = false;
                gp.cChecker.checkTile(this);
                gp.cChecker.checkObject(this, true);
                if (!collisionOn) {
                    worldX += speed;
                }
            }

            updateSpriteCounter();

        } else {

            long timeSinceLastInput = System.nanoTime() - lastDirectionInputTime;

            if (timeSinceLastInput >= 3_000_000_000L) { // 3 seconds

                resetDirection = true;

            } else {

                idling = true;

            }

            updateSpriteCounter();

        }

    }

    public void pickUpObject(int i) {

        if (i != 999) {

        }

    }

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.WHITE);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        int spriteIndex = spriteNum - 1;

        String displayDirection = direction;

        if (idling) {
            displayDirection = "idle";
        }

        if (resetDirection) {
            direction = "idle";
        }

        switch (displayDirection) {
            case "idle":
                image = pi[spriteIndex];
                break;
            case "up":
                image = pu[spriteIndex];
                break;
            case "down":
                image = pd[spriteIndex];
                break;
            case "left":
                image = pl[spriteIndex];
                break;
            case "right":
                image = pr[spriteIndex];
                break;
        }

        // int x = screenX;
        // int y = screenY;

        // if (screenX > worldX) {
        // x = worldX;
        // }

        // if (screenY > worldY) {
        // y = worldY;
        // }

        // int rightOffset = gp.screenWidth - screenX;
        // if (rightOffset > gp.worldWidth - worldX) {
        // x = gp.screenWidth - (gp.worldWidth - worldX);
        // }

        // int bottomOffset = gp.screenHeight - screenY;
        // if (bottomOffset > gp.worldHeight - worldY) {
        // y = gp.screenHeight - (gp.worldHeight - worldY);
        // }

        g2.drawImage(image, screenX, screenY, null);

        // show player hitbox
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }

}

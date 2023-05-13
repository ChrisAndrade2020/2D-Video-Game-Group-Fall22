package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

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

    // Constructor of the Player class, initializing the player's attributes and
    // loading the player's images
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.playerSize / 2) - 2;
        screenY = gp.screenHeight / 2 - (gp.playerSize - 48);

        solidArea = new Rectangle();
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

    // Sets the default values for the player's world position, speed, and direction
    public void setDefaultValues() {
        worldX = gp.tileSize * 6;
        worldY = gp.tileSize * 92;
        speed = 4;
        direction = "idle";
    }

    // Loads the player's images for different directions from the resources
    public void getPlayerImage() {
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

    // Updates the sprite counter which is used to change the player's sprite image,
    // creating an animation effect
    public void updateSpriteCounter() {
        spriteCounter++;

        if (spriteCounter > 6) {
            spriteNum = (spriteNum % 6) + 1;
            spriteCounter = 0;
        }
    }

    // Method reads an image file and returns a scaled version of the image.
    public BufferedImage setup(String imageName) {
        UtilityTool tool = new UtilityTool();
        BufferedImage image = null;

        try {
            BufferedImage originalImage = ImageIO
                    .read(getClass().getResourceAsStream("/res/player/" + imageName + ".png"));
            image = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            image.getGraphics().drawImage(originalImage, 0, 0, null);
            image = tool.scaledImage(image, gp.playerSize, gp.playerSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    // Updates the player's direction and position if there is no collision
    private void updateDirection(String direction, int speedModifierX, int speedModifierY) {
        this.direction = direction;
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, true);

        if (!collisionOn) {
            worldX += speed * speedModifierX;
            worldY += speed * speedModifierY;
        }
    }

    // Updates the player's status, including its position, direction, and sprite
    // image
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
                updateDirection("up", 0, -1);
            }
            if (keyH.down) {
                updateDirection("down", 0, 1);
            }
            if (keyH.left) {
                updateDirection("left", -1, 0);
            }
            if (keyH.right) {
                updateDirection("right", 1, 0);
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

    // Handles the player's interaction with the objects in the game
    public void pickUpObject(int i) {
        if (i != 999) {

        }
    }

    // Draws the player's current sprite image on the screen
    public void draw(Graphics2D g2) {
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

        g2.drawImage(image, screenX, screenY, null);
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}

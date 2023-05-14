package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Entity {

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

        super(gp); // We are calling the constructor of the super class of this class ( entity )
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - ((gp.playerSize / 2) - 2);
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
        speed = 10;
        direction = "idle";
    }

    // Loads the player's images for different directions from the resources
    public void getPlayerImage() {
        pi = loadImages("/res/player/", "pi_", 6);
        pu = loadImages("/res/player/", "pu_", 6);
        pd = loadImages("/res/player/", "pd_", 6);
        pl = loadImages("/res/player/", "pl_", 6);
        pr = loadImages("/res/player/", "pr_", 6);
    }

    public BufferedImage setup(String imageName) {
        UtilityTool tool = new UtilityTool();
        BufferedImage image = null;

        try {
            BufferedImage originalImage = ImageIO
                    .read(getClass().getResourceAsStream(imageName + ".png"));
            image = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            image.getGraphics().drawImage(originalImage, 0, 0, null);
            image = tool.scaledImage(image, gp.playerSize, gp.playerSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    // Updates the sprite counter which is used to change the player's sprite image,
    public void updateSpriteCounter() {
        spriteCounter++;

        if (spriteCounter > 6) {
            spriteNum = (spriteNum % 6) + 1;
            spriteCounter = 0;
        }
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

        int x = screenX;
        int y = screenY;

        if (gp.player.screenX > worldX) {
            x = worldX;
        }

        if (gp.player.screenY > worldY) {
            y = worldY;
        }

        int rightOffset = gp.screenWidth - screenX;
        if (rightOffset > gp.worldWidth - worldX) {
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }

        int bottomOffset = gp.screenHeight - screenY;
        if (bottomOffset > gp.worldHeight - worldY) {
            y = gp.screenHeight - (gp.worldHeight - worldY);
        }

        g2.drawImage(image, x, y, null);
        g2.setColor(Color.red);
        g2.drawRect(x + solidArea.x, y + solidArea.y, solidArea.width, solidArea.height);
    }
}

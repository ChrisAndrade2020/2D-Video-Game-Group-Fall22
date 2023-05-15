package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

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

    // Constructor for the Player class, initializes the player's attributes and
    // loads the player's images
    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);
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

        this.entitySize = 144;
    }

    // Sets the default values for the player's world position, speed, and direction
    public void setDefaultValues() {
        worldX = gp.tileSize * 6;
        worldY = gp.tileSize * 92;
        speed = 10; // to explore world for now will be set to 4 in actual game
        direction = "idle";

        maxHealth = 3;
        health = maxHealth;
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

    // Helper method to set up and scale the player's images
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

    // Updates the player's direction and position based on the input direction and
    // speed modifiers, checks for collisions with tiles, objects, and entities
    private void updateDirection(String direction, int speedModifierX, int speedModifierY) {
        this.direction = direction;
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, true);
        gp.cChecker.checkEntity(this, gp.npc);

        if (!collisionOn) {
            worldX += speed * speedModifierX;
            worldY += speed * speedModifierY;
        }
    }

    // Overrides the updateSpecific() method from the superclass Entity and updates
    // the player's specific behavior, such as picking up objects and interacting
    // with NPCs based on keyboard inputs
    @Override
    protected void updateSpecific() {
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

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

        } else {

            long timeSinceLastInput = System.nanoTime() - lastDirectionInputTime;

            if (timeSinceLastInput >= 3_000_000_000L) { // 3 seconds
                resetDirection = true;
            } else {
                idling = true;
            }

        }
    }

    // Handles the player's interaction with the objects in the game
    public void pickUpObject(int i) {
        if (i != 999) {

        }
    }

    // Handles the player's interaction with NPCs in the game
    public void interactNPC(int i) {
        if (i != 999) {

            if (gp.keyH.enter == true) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }

        gp.keyH.enter = false;
    }

    // Returns the current sprite image based on the player's direction and idling
    // state
    public BufferedImage getCurrentSprite() {
        int spriteIndex = spriteNum - 1;
        String displayDirection = direction;

        if (idling) {
            displayDirection = "idle";
        }

        if (resetDirection) {
            direction = "idle";
        }

        switch (displayDirection) {
            case "right":
                return pr[spriteIndex];
            case "left":
                return pl[spriteIndex];
            case "up":
                return pu[spriteIndex];
            case "down":
                return pd[spriteIndex];
            default:
                return pi[spriteIndex];
        }
    }

    // Overrides the draw() method from the superclass Entity and draws the player's
    // current sprite image on the screen
    @Override
    public void draw(Graphics2D g2) {

        currentSprite = getCurrentSprite();
        solidAreaOffsetX = 0;
        solidAreaOffsetY = 0;

        super.draw(g2);
    }
}
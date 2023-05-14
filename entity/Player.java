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

    private int pushbackDistance = 1;

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

        this.entitySize = 144;
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
        gp.cChecker.checkEntity(this, gp.npc);

        if (!collisionOn) {
            worldX += speed * speedModifierX;
            worldY += speed * speedModifierY;
        }
    }

    @Override
    protected void updateSpecific() {
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);

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

    // Draws the player's current sprite image on the screen
    @Override
    public void draw(Graphics2D g2) {
        // Set the current sprite and solid area offsets
        currentSprite = getCurrentSprite();
        solidAreaOffsetX = 0;
        solidAreaOffsetY = 0;

        // Call the parent class's draw method
        super.draw(g2);
    }
}
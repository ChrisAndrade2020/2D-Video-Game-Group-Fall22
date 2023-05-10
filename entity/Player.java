package entity;

import main.GamePanel;
import main.KeyHandler;
import object.ObjectDoorOpen;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    int hasSword = 0;
    int hasIronKey = 0;
    int hasGoldKey = 0;
    int hasArmor = 0;
    int hasBoots = 0;

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

        screenX = gp.screenWidth / 2 - (gp.playerSize / 2);
        screenY = gp.screenHeight / 2 - (gp.playerSize / 2);

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

        worldX = gp.tileSize * 20;
        worldY = gp.tileSize * 20;
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

        try {
            for (int i = 0; i < 6; i++) {
                pi[i] = ImageIO.read(getClass().getResourceAsStream("/res/player/pi_" + (i + 1) + ".png"));
                pu[i] = ImageIO.read(getClass().getResourceAsStream("/res/player/pu_" + (i + 1) + ".png"));
                pd[i] = ImageIO.read(getClass().getResourceAsStream("/res/player/pd_" + (i + 1) + ".png"));
                pl[i] = ImageIO.read(getClass().getResourceAsStream("/res/player/pl_" + (i + 1) + ".png"));
                pr[i] = ImageIO.read(getClass().getResourceAsStream("/res/player/pr_" + (i + 1) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSpriteCounter() {
        spriteCounter++;

        if (spriteCounter > 6) {
            spriteNum = (spriteNum % 6) + 1;
            spriteCounter = 0;
        }
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

            // If this index is 999, it means we did not touch an object. Otherwise player
            // touched an object.

            // gp.obj[i] = null; // deletes object we touch.

            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Gold Key":
                    hasGoldKey++;
                    gp.obj[i] = null; // makes sword disappear once touched
                    System.out.println("Obtained a Gold Key!");
                    break;

                case "Iron Key":
                    hasIronKey++;
                    gp.obj[i] = null; // makes sword disappear once touched
                    System.out.println("Obtained a Iron Key!");
                    break;

                case "ChestArmor":

                    if (hasGoldKey > 0) {

                        hasArmor++;
                        gp.obj[i] = null;
                        System.out.println("Obtained Leather Armor!");
                        hasGoldKey--;
                        System.out.println("Gold Key(s) Remaining: " + hasGoldKey);

                    }

                    else {

                        System.out.println("Needs a gold key!");

                    }

                    break;

                case "ChestBoots":
                    if (hasGoldKey > 0) {

                        hasBoots++;
                        gp.obj[i] = null;
                        System.out.println("Obtained Leather Boots");
                        hasGoldKey--;
                        System.out.println("Gold Key(s) Remaining: " + hasGoldKey);
                        speed += 2;
                        System.out.println("You feel like you can run faster!");

                    }

                    else {

                        System.out.println("Needs a gold key!");

                    }

                    break;

                case "ChestSword":
                    if (hasGoldKey > 0) {

                        hasSword++;
                        gp.obj[i] = null;
                        System.out.println("Obtained an Iron Sword!");
                        hasGoldKey--;
                        System.out.println("Gold Key(s) Remaining: " + hasGoldKey);

                    }

                    else {

                        System.out.println("Needs a gold key!");

                    }

                    break;

                case "DoorClosed":
                    if (hasIronKey > 0) {
                        // Store the original position of the DoorClosed object
                        int originalWorldX = gp.obj[i].worldX;
                        int originalWorldY = gp.obj[i].worldY;

                        // Replace the DoorClosed object with an ObjectDoorOpen object
                        gp.obj[i] = new ObjectDoorOpen();
                        gp.obj[i].worldX = originalWorldX;
                        gp.obj[i].worldY = originalWorldY;

                        hasIronKey--;

                        System.out.println("Iron Key(s) Remaining: " + hasIronKey);
                    }

                    else {

                        System.out.println("Needs an iron key!");

                    }

                    break;

            }

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

        g2.drawImage(image, screenX, screenY, gp.playerSize, gp.playerSize, null);

        // show player hitbox
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }

}

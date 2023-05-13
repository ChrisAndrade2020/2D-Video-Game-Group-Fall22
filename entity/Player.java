package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
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
    public int hasSword = 0;
    public int hasIronKey = 0;
    public int hasGoldKey = 0;
    public int hasArmor = 0;
    public int hasBoots = 0;

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
        worldY = gp.tileSize * 88;
        speed = 8;
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

            // If this index is 999, it means we did not touch an object. Otherwise player
            // touched an object.

            // gp.obj[i] = null; // deletes object we touch.

            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Gold Key":
                    gp.playSFX(2);
                    hasGoldKey++;
                    gp.obj[i] = null; // makes key disappear once touched
                    // System.out.println("Obtained a Gold Key!");
                    break;

                case "Iron Key":
                    gp.playSFX(2);
                    hasIronKey++;
                    gp.obj[i] = null; // makes key disappear once touched
                    // System.out.println("Obtained a Iron Key!");
                    break;

                case "ChestArmor":

                    if (hasGoldKey > 0) {
                        gp.playSFX(3);
                        hasArmor++;
                        gp.obj[i] = null;
                        gp.ui.showMessage("Obtained Leather Armor!");
                        // System.out.println("Obtained Leather Armor!");
                        hasGoldKey--;
                        // System.out.println("Gold Key(s) Remaining: " + hasGoldKey);

                    }

                    else {
                        if (!gp.obj[i].collisionSFXPlayed) {
                            gp.playSFX(1);
                            gp.ui.showMessage("Chest is locked...");
                            // System.out.println("Needs a gold key!");
                            gp.obj[i].collisionSFXPlayed = true; // Set the flag
                        }
                    }

                    break;

                case "ChestBoots":
                    if (hasGoldKey > 0) {
                        gp.playSFX(3);
                        hasBoots++;
                        gp.obj[i] = null;
                        gp.ui.showMessage("Obtained Leather Boots");
                        // System.out.println("Obtained Leather Boots");
                        hasGoldKey--;
                        // System.out.println("Gold Key(s) Remaining: " + hasGoldKey);
                        speed += 2;
                        gp.ui.showMessage("You feel like you can run faster!");
                        // System.out.println("You feel like you can run faster!");

                    }

                    else {
                        if (!gp.obj[i].collisionSFXPlayed) {
                            gp.playSFX(1);
                            gp.ui.showMessage("Chest is locked...");
                            // System.out.println("Needs a gold key!");
                            gp.obj[i].collisionSFXPlayed = true; // Set the flag
                        }
                    }

                    break;

                case "ChestSword":
                    if (hasGoldKey > 0) {
                        gp.playSFX(3);
                        hasSword++;
                        gp.obj[i] = null;
                        gp.ui.showMessage("Obtained an Iron Sword!");
                        // System.out.println("Obtained an Iron Sword!");
                        hasGoldKey--;
                        gp.ui.showMessage("Used a Key!");
                        // System.out.println("Gold Key(s) Remaining: " + hasGoldKey);

                    }

                    else {
                        if (!gp.obj[i].collisionSFXPlayed) {
                            gp.playSFX(1);
                            gp.ui.showMessage("Chest is locked...");
                            // System.out.println("Needs a gold key!");
                            gp.obj[i].collisionSFXPlayed = true; // Set the flag
                        }
                    }

                    break;

                case "DoorClosed":
                    if (hasIronKey > 0 && gp.obj[i].collisionSFXPlayed) {
                        gp.playSFX(5);
                        // Store the original position of the DoorClosed object
                        int originalWorldX = gp.obj[i].worldX;
                        int originalWorldY = gp.obj[i].worldY;

                        // Replace the DoorClosed object with an ObjectDoorOpen object
                        gp.obj[i] = new ObjectDoorOpen(gp);
                        gp.obj[i].worldX = originalWorldX;
                        gp.obj[i].worldY = originalWorldY;

                        gp.obj[i].collisionSFXPlayed = false; // Set the flag

                        gp.ui.showMessage("Door is open!");
                        hasIronKey--;

                        // System.out.println("Iron Key(s) Remaining: " + hasIronKey);
                    } else if (!gp.obj[i].collisionSFXPlayed) {
                        gp.playSFX(1);
                        gp.ui.showMessage("Door is locked...");
                        // System.out.println("Needs an iron key!");
                        gp.obj[i].collisionSFXPlayed = true; // Set the flag
                    }
                    break;

                case "Bed1":
                case "Bed2":

                    gp.ui.gameFinish = true;
                    gp.stopMusic();
                    gp.playSFX(4);

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

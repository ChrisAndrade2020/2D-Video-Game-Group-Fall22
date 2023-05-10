package entity;

import main.GamePanel;
import main.KeyHandler;

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
    int hasChest = 0;

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

    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 20;
        worldY = gp.tileSize * 20;
        speed = 4;
        direction = "idle";

    }

    public void getPlayerImage() {

        try {

            pi_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/pi_1.png"));
            pi_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/pi_2.png"));
            pi_3 = ImageIO.read(getClass().getResourceAsStream("/res/player/pi_3.png"));
            pi_4 = ImageIO.read(getClass().getResourceAsStream("/res/player/pi_4.png"));
            pi_5 = ImageIO.read(getClass().getResourceAsStream("/res/player/pi_5.png"));
            pi_6 = ImageIO.read(getClass().getResourceAsStream("/res/player/pi_6.png"));

            pu_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/pu_1.png"));
            pu_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/pu_2.png"));
            pu_3 = ImageIO.read(getClass().getResourceAsStream("/res/player/pu_3.png"));
            pu_4 = ImageIO.read(getClass().getResourceAsStream("/res/player/pu_4.png"));
            pu_5 = ImageIO.read(getClass().getResourceAsStream("/res/player/pu_5.png"));
            pu_6 = ImageIO.read(getClass().getResourceAsStream("/res/player/pu_6.png"));

            pd_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/pd_1.png"));
            pd_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/pd_2.png"));
            pd_3 = ImageIO.read(getClass().getResourceAsStream("/res/player/pd_3.png"));
            pd_4 = ImageIO.read(getClass().getResourceAsStream("/res/player/pd_4.png"));
            pd_5 = ImageIO.read(getClass().getResourceAsStream("/res/player/pd_5.png"));
            pd_6 = ImageIO.read(getClass().getResourceAsStream("/res/player/pd_6.png"));

            pl_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/pl_1.png"));
            pl_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/pl_2.png"));
            pl_3 = ImageIO.read(getClass().getResourceAsStream("/res/player/pl_3.png"));
            pl_4 = ImageIO.read(getClass().getResourceAsStream("/res/player/pl_4.png"));
            pl_5 = ImageIO.read(getClass().getResourceAsStream("/res/player/pl_5.png"));
            pl_6 = ImageIO.read(getClass().getResourceAsStream("/res/player/pl_6.png"));

            pr_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/pr_1.png"));
            pr_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/pr_2.png"));
            pr_3 = ImageIO.read(getClass().getResourceAsStream("/res/player/pr_3.png"));
            pr_4 = ImageIO.read(getClass().getResourceAsStream("/res/player/pr_4.png"));
            pr_5 = ImageIO.read(getClass().getResourceAsStream("/res/player/pr_5.png"));
            pr_6 = ImageIO.read(getClass().getResourceAsStream("/res/player/pr_6.png"));

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

        if (keyH.up == true || keyH.down == true || keyH.left == true || keyH.right == true) {

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
            direction = "idle"; // for idle sprite animation
            updateSpriteCounter();
        }
    }

    // CLEANER IMPLEMENTATION BUT REMOVES ABILITY TO MOVE DIAGONALLY
    // Check tile collision
    // collisionOn = false;
    // gp.cChecker.checkTile(this); // Since player class is a subclass of Entity
    // class, the collision checker can
    // // recieve player class as entity.

    // // If collision is false, player moves through the tile.

    // // if (collisionOn == false) {

    // // switch (direction) {
    // // case "up":
    // // worldY -= speed;
    // // break;

    // // case "down":
    // // worldY += speed;
    // // break;

    // // case "left":
    // // worldX -= speed;
    // // break;

    // // case "right":
    // // worldX += speed;
    // // break;

    // // }
    // // }

    public void pickUpObject(int i) {

        if (i != 999) {

            // If this index is 999, it means we did not touch an object. Otherwise player
            // touched an object.

            // gp.obj[i] = null; // deletes object we touch.

            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Sword":
                    hasSword++;
                    gp.obj[i] = null; // makes sword disappear once touched
                    System.out.println("Sword: " + hasSword);
                    break;
                case "Chest":
                    hasChest++;
                    break;
                case "Door":
                    if (hasSword > 0) {
                        gp.obj[i] = null; // makes door disappear and decrement number of sword
                        hasSword--;
                    }
                    System.out.println("Sword: " + hasSword);
                    System.out.println("Collision" + collisionOn);
                    break;
            }

        }

    }

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.WHITE);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "idle":
                if (spriteNum == 1) {
                    image = pi_1;
                }
                if (spriteNum == 2) {
                    image = pi_2;
                }
                if (spriteNum == 3) {
                    image = pi_3;
                }
                if (spriteNum == 4) {
                    image = pi_4;
                }
                if (spriteNum == 5) {
                    image = pi_5;
                }
                if (spriteNum == 6) {
                    image = pi_6;
                }
                break;
            case "up":
                if (spriteNum == 1) {
                    image = pu_1;
                }
                if (spriteNum == 2) {
                    image = pu_2;
                }
                if (spriteNum == 3) {
                    image = pu_3;
                }
                if (spriteNum == 4) {
                    image = pu_4;
                }
                if (spriteNum == 5) {
                    image = pu_5;
                }
                if (spriteNum == 6) {
                    image = pu_6;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = pd_1;
                }
                if (spriteNum == 2) {
                    image = pd_2;
                }
                if (spriteNum == 3) {
                    image = pd_3;
                }
                if (spriteNum == 4) {
                    image = pd_4;
                }
                if (spriteNum == 5) {
                    image = pd_5;
                }
                if (spriteNum == 6) {
                    image = pd_6;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = pl_1;
                }
                if (spriteNum == 2) {
                    image = pl_2;
                }
                if (spriteNum == 3) {
                    image = pl_3;
                }
                if (spriteNum == 4) {
                    image = pl_4;
                }
                if (spriteNum == 5) {
                    image = pl_5;
                }
                if (spriteNum == 6) {
                    image = pl_6;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = pr_1;
                }
                if (spriteNum == 2) {
                    image = pr_2;
                }
                if (spriteNum == 3) {
                    image = pr_3;
                }
                if (spriteNum == 4) {
                    image = pr_4;
                }
                if (spriteNum == 5) {
                    image = pr_5;
                }
                if (spriteNum == 6) {
                    image = pr_6;
                }
                break;

        }

        g2.drawImage(image, screenX, screenY, gp.playerSize, gp.playerSize, null);
        // show player hitbox
        g2.setColor(Color.red);
        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);

    }

}

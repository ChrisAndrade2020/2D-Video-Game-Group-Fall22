package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.image.BufferedImage;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
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

    public void update() {

        if (keyH.up == true || keyH.down == true || keyH.left == true || keyH.right == true) {

            if (keyH.up == true) {
                direction = "up";
                y -= speed;
            }
            if (keyH.down == true) {
                direction = "down";
                y += speed;
            }
            if (keyH.left == true) {
                direction = "left";
                x -= speed;
            }
            if (keyH.right == true) {
                direction = "right";
                x += speed;
            }

            spriteCounter++; // increments every time update is called which is every 16.67ms

            if (spriteCounter > 6) {

                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 5;
                } else if (spriteNum == 5) {
                    spriteNum = 6;
                } else if (spriteNum == 6) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }

        else {
            direction = "idle"; // for idle sprite animation

            spriteCounter++;

            if (spriteCounter > 6) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 5;
                } else if (spriteNum == 5) {
                    spriteNum = 6;
                } else if (spriteNum == 6) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
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

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }

}

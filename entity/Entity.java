package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

    protected int screenX;
    protected int screenY;

    protected GamePanel gp;

    public int worldX, worldY;
    public int speed;

    public BufferedImage pi_1, pi_2, pi_3, pi_4, pi_5, pi_6,
            pu_1, pu_2, pu_3, pu_4, pu_5, pu_6,
            pd_1, pd_2, pd_3, pd_4, pd_5, pd_6,
            pl_1, pl_2, pl_3, pl_4, pl_5, pl_6,
            pr_1, pr_2, pr_3, pr_4, pr_5, pr_6,
            slime_idle1, slime_idle2, slime_idle3, slime_idle4, slime_idle5, slime_idle6,
            slime_move1, slime_move2, slime_move3, slime_move4, slime_move5, slime_move6;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn = false;

    protected boolean collisionSFXPlayed = false;
    protected boolean messageDisplayed = false;

    protected BufferedImage currentSprite;
    protected int solidAreaOffsetX;
    protected int solidAreaOffsetY;

    protected int entitySize;

    protected Random random = new Random();
    protected int moveCounter = 0;
    protected String[] directions = { "idle", "up", "down", "left", "right" };
    protected boolean idling = false;
    protected boolean resetDirection = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public BufferedImage setup(String imagePath) {
        UtilityTool tool = new UtilityTool();
        BufferedImage image = null;

        try {
            BufferedImage originalImage = ImageIO
                    .read(getClass().getResourceAsStream(imagePath + ".png"));
            image = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            image.getGraphics().drawImage(originalImage, 0, 0, null);
            image = tool.scaledImage(image, gp.playerSize, gp.playerSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public void update() {
        // Checks tile and object collision
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, true);

        // Call the specific update logic of each subclass (Player or NPC_Slime)
        updateSpecific();

        // Update the sprite counter
        updateSpriteCounter();
    }

    protected void updateSpecific() {
        // Overridden by specific subclasses
    }

    protected void updateSpriteCounter() {
        spriteCounter++;

        if (spriteCounter >= 6) {
            spriteNum = (spriteNum % 6) + 1;
            spriteCounter = 0;
        }
    }

    public void randomMovement() {
        if (moveCounter % 60 == 0) {
            direction = directions[random.nextInt(directions.length)];
        }

        // Move Entity in direction if no collision
        if (!collisionOn) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }

        // Increment spriteCounter every update
        spriteCounter++;

        // Reset spriteCounter and increment spriteNum after every 6 counts
        if (spriteCounter >= 10) {
            spriteCounter = 0;
            spriteNum = (spriteNum % 6) + 1;
        }

        moveCounter++;
    }

    public void draw(Graphics2D g2) {
        int x = worldX - gp.player.worldX + gp.player.screenX + solidAreaOffsetX;
        int y = worldY - gp.player.worldY + gp.player.screenY + solidAreaOffsetY;

        if (gp.player.worldX < gp.player.screenX) {
            x = worldX;
        }

        if (gp.player.worldY < gp.player.screenY) {
            y = worldY;
        }

        int rightOffset = gp.screenWidth - gp.player.screenX;
        if (rightOffset > gp.worldWidth - gp.player.worldX) {
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }

        int bottomOffset = gp.screenHeight - gp.player.screenY;
        if (bottomOffset > gp.worldHeight - gp.player.worldY) {
            y = gp.screenHeight - (gp.worldHeight - worldY);
        }

        g2.drawImage(currentSprite, x, y, entitySize, entitySize, null);
        g2.setColor(Color.red);
        g2.drawRect(x + solidArea.x, y + solidArea.y, solidArea.width, solidArea.height);

        System.out.println("sprite counter: " + spriteCounter);
        // System.out.println("sprite index: " + spriteIndex);
        System.out.println("move counter: " + moveCounter);
    }

}

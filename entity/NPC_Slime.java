package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import main.GamePanel;

public class NPC_Slime extends Entity {

    private BufferedImage[] idle;
    private BufferedImage[] move;

    private Random random = new Random();
    private int moveCounter = 0;
    private String[] directions = { "idle", "up", "down", "left", "right" };

    public NPC_Slime(GamePanel gp) {

        super(gp);

        loadNPCEntitySprites();
        setDefaultValues();

        solidArea = new Rectangle();
        solidArea.x = 30;
        solidArea.y = 42;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        solidArea.width = 36;
        solidArea.height = 24;
    }

    public void setDefaultValues() {
        worldX = gp.tileSize;
        worldY = gp.tileSize;
        speed = 2;
        direction = "idle";
    }

    private void loadNPCEntitySprites() {
        idle = new BufferedImage[6];
        move = new BufferedImage[6];

        for (int i = 0; i < 6; i++) {
            idle[i] = setup("/res/npc/slime_idle" + (i + 1));
            move[i] = setup("/res/npc/slime_move" + (i + 1));
        }
    }

    @Override
    public void update() {
        // Check for collision
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false); // NPC does not pick up objects

        // NPC will randomly change direction every 20 updates
        if (moveCounter % 60 == 0) {
            direction = directions[random.nextInt(directions.length)];
        }

        // Move NPC in direction if no collision
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

        this.collisionOn = false;

        // Increment spriteCounter every update
        spriteCounter++;

        // Reset spriteCounter and increment spriteNum after every 6 counts
        if (spriteCounter >= 6) {
            spriteCounter = 0;
            spriteNum = (spriteNum % 6) + 1;
        }

        moveCounter++;

        int spriteIndex = (spriteNum - 1) % 6; // Use modulo 6 to ensure spriteIndex is always between 0 and 5

        BufferedImage image = null;

        if (direction.equals("idle")) {
            image = idle[spriteIndex];
        } else {
            image = move[spriteIndex];
        }

        spriteIndex++;

    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int spriteIndex = spriteNum - 1;
        String displayDirection = direction;

        if (direction.equals("idle")) {
            displayDirection = "idle";
        }

        switch (displayDirection) {
            case "idle":
                image = idle[spriteIndex];
                break;
            default: // "up", "down", "left", "right" are treated the same for the slime
                image = move[spriteIndex];
                break;
        }

        int x = worldX - gp.player.worldX + gp.player.screenX;
        int y = worldY - gp.player.worldY + gp.player.screenY;

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

        if (worldX + (gp.tileSize) > gp.player.worldX - gp.player.screenX &&
                worldX - (gp.tileSize * 4) < gp.player.worldX + gp.player.screenX &&
                worldY + (gp.tileSize) > gp.player.worldY - gp.player.screenY &&
                worldY - (gp.tileSize * 4) < gp.player.worldY + gp.player.screenY) {

            g2.drawImage(image, x, y, gp.entitySize, gp.entitySize, null);
            g2.setColor(Color.red);
            g2.drawRect(x + solidArea.x, y + solidArea.y, solidArea.width, solidArea.height);

            System.out.println("sprite counter: " + spriteCounter);
            System.out.println("sprite index: " + spriteIndex);
            System.out.println("move counter: " + moveCounter);

        }
    }

}

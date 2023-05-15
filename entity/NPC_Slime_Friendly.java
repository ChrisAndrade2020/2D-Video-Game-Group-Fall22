package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class NPC_Slime_Friendly extends Entity {

    private BufferedImage[] idle;
    private BufferedImage[] move;

    private boolean idling;
    private boolean resetDirection;

    public NPC_Slime_Friendly(GamePanel gp) {
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
        this.entitySize = 96;
    }

    // Sets the default values for the NPC's world position, speed, and direction
    private void setDefaultValues() {
        worldX = gp.tileSize;
        worldY = gp.tileSize;
        speed = 1;
        direction = "idle";
    }

    // Loads the NPC's sprites for idle and movement animations
    private void loadNPCEntitySprites() {
        idle = new BufferedImage[6];
        move = new BufferedImage[6];
        for (int i = 0; i < 6; i++) {
            idle[i] = setup("/res/npc/slime_idle" + (i + 1));
            move[i] = setup("/res/npc/slime_move" + (i + 1));
        }
    }

    // Similar to Player class
    @Override
    protected void updateSpecific() {
        randomMovement();
        int spriteIndex = (spriteNum - 1) % 6; // Use modulo 6 to ensure spriteIndex is always between 0 and 5
        BufferedImage image = null;
        if (direction.equals("idle")) {
            image = idle[spriteIndex];
        } else {
            image = move[spriteIndex];
        }
        spriteIndex++;
    }

    // Updates the NPC's position to the new coordinates and checks for collisions
    public void updatePosition(int newX, int newY) {
        int oldWorldX = worldX; // Save the old position
        int oldWorldY = worldY;
        worldX = newX; // Update the position
        worldY = newY;
        collisionOn = false; // Check for collisions
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, true);
        gp.cChecker.checkEntity(this, gp.npc);
        if (collisionOn) { // If a collision is detected, revert to the old position
            worldX = oldWorldX;
            worldY = oldWorldY;
        }
    }

    // Returns the current sprite image based on the NPC's direction and idling
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
                return move[spriteIndex];
            case "left":
                return move[spriteIndex];
            case "up":
                return move[spriteIndex];
            case "down":
                return move[spriteIndex];
            default:
                return idle[spriteIndex];
        }
    }

    // Similar to Player class
    @Override
    public void draw(Graphics2D g2) {
        currentSprite = getCurrentSprite(); // Set the current sprite and solid area offsets
        solidAreaOffsetX = 0;
        solidAreaOffsetY = 0;
        super.draw(g2);
    }
}

package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class NPC_Skeleton extends Entity {

    private BufferedImage[] idle;
    private BufferedImage[] move;
    private BufferedImage[] moveleft;

    private boolean idling;
    private boolean resetDirection;

    public NPC_Skeleton(GamePanel gp) {
        super(gp);
        loadNPCEntitySprites();
        setDefaultValues();
        solidArea = new Rectangle();
        solidArea.x = 81;
        solidArea.y = 132;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 28;
        solidArea.height = 28;
        this.entitySize = 192;
        setDialogue();
    }

    // Sets the default values for the NPC's world position, speed, and direction
    private void setDefaultValues() {
        worldX = gp.tileSize;
        worldY = gp.tileSize;
        speed = 4;
        direction = "idle";
    }

    public void setDialogue() {

        dialogues[0] = "skele skele";
        dialogues[1] = "What are you looking at?!";
        dialogues[2] = "You just gonna stare at me or what? \nFirst time seeing a talking slime?";
        dialogues[3] = "...";
        dialogues[4] = "If you're just gonna stare at me all day \ngo and make yourself useful!";

    }

    // Loads the NPC's sprites for idle and movement animations
    private void loadNPCEntitySprites() {
        idle = new BufferedImage[6];
        move = new BufferedImage[6];
        moveleft = new BufferedImage[6];
        for (int i = 0; i < 6; i++) {
            idle[i] = setup("/res/monster/skeleton_idle" + (i + 1));
            move[i] = setup("/res/monster/skeleton_move_udr" + (i + 1)); // udr = up down right
            moveleft[i] = setup("/res/monster/skeleton_move_l" + (i + 1));
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
        }
        if (direction.equals("left")) {
            image = moveleft[spriteIndex];
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
                return moveleft[spriteIndex];
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

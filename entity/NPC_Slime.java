package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class NPC_Slime extends Entity {

    private BufferedImage[] idle;
    private BufferedImage[] move;

    private boolean idling;
    private boolean resetDirection;

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

        this.entitySize = 96;
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

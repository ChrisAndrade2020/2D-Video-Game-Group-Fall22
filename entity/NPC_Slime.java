package entity;

import java.awt.image.BufferedImage;
import main.GamePanel;

public class NPC_Slime extends Entity {

    private boolean idling;

    private BufferedImage[] si;
    private BufferedImage[] sm;

    public NPC_Slime(GamePanel gp) {
        super(gp);

        idling = false;
        speed = 2;

    }

    public void getPlayerImage() {
        si = new BufferedImage[6];
        sm = new BufferedImage[6];

        for (int i = 0; i < 6; i++) {
            si[i] = setup("/res/npc/slime_idle" + (i + 1));
            sm[i] = setup("/res/npc/slime_move" + (i + 1));

        }
    }

    // Updates the sprite counter which is used to change the NPC's sprite image,
    public void updateSpriteCounter() {
        spriteCounter++;

        if (spriteCounter > 6) {
            spriteNum = (spriteNum % 6) + 1;
            spriteCounter = 0;
        }
    }

    // Updates the NPC's direction and position if there is no collision
    private void updateDirection(String direction, int speedModifierX, int speedModifierY) {
        this.direction = direction;
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, true);

        if (!collisionOn) {
            worldX += speed * speedModifierX;
            worldY += speed * speedModifierY;
        }
    }

}

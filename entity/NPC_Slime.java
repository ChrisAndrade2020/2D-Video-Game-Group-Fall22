package entity;

import java.awt.image.BufferedImage;

import main.GamePanel;

public class NPC_Slime extends Entity {

    private BufferedImage[] si;
    private BufferedImage[] sm;

    public NPC_Slime(GamePanel gp) {

        super(gp);
        direction = "idle";
        speed = 2;
        si = loadImages("/res/npc/", "slime_idle", 6);
        sm = loadImages("/res/npc/", "slime_move", 6);

    }

}

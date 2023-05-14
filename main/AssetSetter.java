package main;

import entity.NPC_Slime;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        // ...code to set objects...
    }

    public void setNPC() {
        gp.npc[0] = new NPC_Slime(gp);
        gp.npc[0].worldX = gp.tileSize * 13;
        gp.npc[0].worldY = gp.tileSize * 87;

        gp.npc[1] = new NPC_Slime(gp);
        gp.npc[1].worldX = gp.tileSize * 14;
        gp.npc[1].worldY = gp.tileSize * 87;

        gp.npc[2] = new NPC_Slime(gp);
        gp.npc[2].worldX = gp.tileSize * 15;
        gp.npc[2].worldY = gp.tileSize * 87;
    }

}
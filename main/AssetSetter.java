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

        gp.npc[3] = new NPC_Slime(gp);
        gp.npc[3].worldX = gp.tileSize * 16;
        gp.npc[3].worldY = gp.tileSize * 87;

        gp.npc[4] = new NPC_Slime(gp);
        gp.npc[4].worldX = gp.tileSize * 13;
        gp.npc[4].worldY = gp.tileSize * 88;

        gp.npc[5] = new NPC_Slime(gp);
        gp.npc[5].worldX = gp.tileSize * 14;
        gp.npc[5].worldY = gp.tileSize * 88;

        gp.npc[6] = new NPC_Slime(gp);
        gp.npc[6].worldX = gp.tileSize * 15;
        gp.npc[6].worldY = gp.tileSize * 88;

        gp.npc[7] = new NPC_Slime(gp);
        gp.npc[7].worldX = gp.tileSize * 16;
        gp.npc[7].worldY = gp.tileSize * 88;

        gp.npc[8] = new NPC_Slime(gp);
        gp.npc[8].worldX = gp.tileSize * 13;
        gp.npc[8].worldY = gp.tileSize * 89;

        gp.npc[9] = new NPC_Slime(gp);
        gp.npc[9].worldX = gp.tileSize * 14;
        gp.npc[9].worldY = gp.tileSize * 89;

        gp.npc[10] = new NPC_Slime(gp);
        gp.npc[10].worldX = gp.tileSize * 15;
        gp.npc[10].worldY = gp.tileSize * 89;

        gp.npc[11] = new NPC_Slime(gp);
        gp.npc[11].worldX = gp.tileSize * 16;
        gp.npc[11].worldY = gp.tileSize * 89;

        gp.npc[12] = new NPC_Slime(gp);
        gp.npc[12].worldX = gp.tileSize * 13;
        gp.npc[12].worldY = gp.tileSize * 90;

        gp.npc[13] = new NPC_Slime(gp);
        gp.npc[13].worldX = gp.tileSize * 14;
        gp.npc[13].worldY = gp.tileSize * 90;

        gp.npc[14] = new NPC_Slime(gp);
        gp.npc[14].worldX = gp.tileSize * 15;
        gp.npc[14].worldY = gp.tileSize * 90;

        gp.npc[15] = new NPC_Slime(gp);
        gp.npc[15].worldX = gp.tileSize * 16;
        gp.npc[15].worldY = gp.tileSize * 90;
    }

}
package main;

import entity.NPC_Skeleton;
import entity.NPC_Slime;
import entity.NPC_Slime_Friendly;

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
        gp.npc[0].worldX = gp.tileSize * 28;
        gp.npc[0].worldY = gp.tileSize * 96;

        gp.npc[1] = new NPC_Slime(gp);
        gp.npc[1].worldX = gp.tileSize * 41;
        gp.npc[1].worldY = gp.tileSize * 89;

        gp.npc[2] = new NPC_Slime(gp);
        gp.npc[2].worldX = gp.tileSize * 32;
        gp.npc[2].worldY = gp.tileSize * 63;

        gp.npc[3] = new NPC_Slime(gp);
        gp.npc[3].worldX = gp.tileSize * 40;
        gp.npc[3].worldY = gp.tileSize * 75;

        gp.npc[4] = new NPC_Slime(gp);
        gp.npc[4].worldX = gp.tileSize * 50;
        gp.npc[4].worldY = gp.tileSize * 55;

        gp.npc[5] = new NPC_Slime(gp);
        gp.npc[5].worldX = gp.tileSize * 55;
        gp.npc[5].worldY = gp.tileSize * 60;

        gp.npc[6] = new NPC_Slime(gp);
        gp.npc[6].worldX = gp.tileSize * 29;
        gp.npc[6].worldY = gp.tileSize * 85;

        gp.npc[7] = new NPC_Slime(gp);
        gp.npc[7].worldX = gp.tileSize * 65;
        gp.npc[7].worldY = gp.tileSize * 80;

        gp.npc[8] = new NPC_Slime(gp);
        gp.npc[8].worldX = gp.tileSize * 62;
        gp.npc[8].worldY = gp.tileSize * 72;

        gp.npc[9] = new NPC_Skeleton(gp);
        gp.npc[9].worldX = gp.tileSize * 55;
        gp.npc[9].worldY = gp.tileSize * 11;

        gp.npc[10] = new NPC_Skeleton(gp);
        gp.npc[10].worldX = gp.tileSize * 27;
        gp.npc[10].worldY = gp.tileSize * 49;

        gp.npc[11] = new NPC_Skeleton(gp);
        gp.npc[11].worldX = gp.tileSize * 12;
        gp.npc[11].worldY = gp.tileSize * 23;

        gp.npc[12] = new NPC_Skeleton(gp);
        gp.npc[12].worldX = gp.tileSize * 60;
        gp.npc[12].worldY = gp.tileSize * 44;

        gp.npc[13] = new NPC_Skeleton(gp);
        gp.npc[13].worldX = gp.tileSize * 71;
        gp.npc[13].worldY = gp.tileSize * 27;

        gp.npc[14] = new NPC_Skeleton(gp);
        gp.npc[14].worldX = gp.tileSize * 68;
        gp.npc[14].worldY = gp.tileSize * 64;

        gp.npc[15] = new NPC_Skeleton(gp);
        gp.npc[15].worldX = gp.tileSize * 88;
        gp.npc[15].worldY = gp.tileSize * 65;

        gp.npc[16] = new NPC_Slime(gp);
        gp.npc[16].worldX = gp.tileSize * 85;
        gp.npc[16].worldY = gp.tileSize * 80;

        gp.npc[17] = new NPC_Slime(gp);
        gp.npc[17].worldX = gp.tileSize * 83;
        gp.npc[17].worldY = gp.tileSize * 70;

        gp.npc[18] = new NPC_Slime_Friendly(gp);
        gp.npc[18].worldX = gp.tileSize * 7;
        gp.npc[18].worldY = gp.tileSize * 88;
    }

}
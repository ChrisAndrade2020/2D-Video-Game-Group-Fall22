package main;

import entity.NPC_Skeleton;
import entity.NPC_Slime;
import entity.NPC_Slime_Friendly;
import object.ObjectBed1;
import object.ObjectBed2;
import object.ObjectChest;
import object.ObjectCrate;
import object.ObjectDoorClosed;
import object.ObjectKeyGold;
import object.ObjectKeyIron;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new ObjectDoorClosed(gp);
        gp.obj[0].worldX = gp.tileSize * 7;
        gp.obj[0].worldY = gp.tileSize * 91;

        gp.obj[1] = new ObjectChest(gp);
        gp.obj[1].worldX = gp.tileSize * 5;
        gp.obj[1].worldY = gp.tileSize * 88;

        gp.obj[2] = new ObjectCrate(gp);
        gp.obj[2].worldX = gp.tileSize * 26;
        gp.obj[2].worldY = (int) (gp.tileSize * 93.5);

        gp.obj[3] = new ObjectKeyGold(gp);
        gp.obj[3].worldX = gp.tileSize * 9;
        gp.obj[3].worldY = gp.tileSize * 89;

        gp.obj[4] = new ObjectKeyIron(gp);
        gp.obj[4].worldX = gp.tileSize * 26;
        gp.obj[4].worldY = gp.tileSize * 93;

        gp.obj[5] = new ObjectBed1(gp);
        gp.obj[5].worldX = gp.tileSize * 5;
        gp.obj[5].worldY = gp.tileSize * 86;

        gp.obj[6] = new ObjectBed2(gp);
        gp.obj[6].worldX = gp.tileSize * 5;
        gp.obj[6].worldY = gp.tileSize * 87;
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
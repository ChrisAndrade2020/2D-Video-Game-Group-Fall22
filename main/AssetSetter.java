package main;

import entity.NPC_Skeleton;
import entity.NPC_Slime_Friendly;
import monster.Slime;
import object.ObjectBed1;
import object.ObjectBed2;
import object.ObjectChest;
import object.ObjectCrate;
import object.ObjectHeart;
import object.ObjectKeyGold;
import object.ObjectKeyIron;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new ObjectHeart(gp);
        gp.obj[0].worldX = gp.tileSize * 7;
        gp.obj[0].worldY = gp.tileSize * 99;

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

        gp.npc[0] = new NPC_Slime_Friendly(gp);
        gp.npc[0].worldX = gp.tileSize * 7;
        gp.npc[0].worldY = gp.tileSize * 88;

        gp.npc[1] = new NPC_Skeleton(gp);
        gp.npc[1].worldX = gp.tileSize * 13;
        gp.npc[1].worldY = gp.tileSize * 85;

    }

    public void setMonster() {

        gp.monster[0] = new Slime(gp);
        gp.monster[0].worldX = gp.tileSize * 13;
        gp.monster[0].worldY = gp.tileSize * 88;

        gp.monster[1] = new Slime(gp);
        gp.monster[1].worldX = gp.tileSize * 14;
        gp.monster[1].worldY = gp.tileSize * 88;

        gp.monster[2] = new Slime(gp);
        gp.monster[2].worldX = gp.tileSize * 15;
        gp.monster[2].worldY = gp.tileSize * 88;

        gp.monster[3] = new Slime(gp);
        gp.monster[3].worldX = gp.tileSize * 16;
        gp.monster[3].worldY = gp.tileSize * 88;

        gp.monster[4] = new Slime(gp);
        gp.monster[4].worldX = gp.tileSize * 17;
        gp.monster[4].worldY = gp.tileSize * 88;

        gp.monster[5] = new Slime(gp);
        gp.monster[5].worldX = gp.tileSize * 18;
        gp.monster[5].worldY = gp.tileSize * 88;

        gp.monster[6] = new Slime(gp);
        gp.monster[6].worldX = gp.tileSize * 19;
        gp.monster[6].worldY = gp.tileSize * 88;

        gp.monster[1] = new Slime(gp);
        gp.monster[1].worldX = gp.tileSize * 20;
        gp.monster[1].worldY = gp.tileSize * 88;

        gp.monster[2] = new Slime(gp);
        gp.monster[2].worldX = gp.tileSize * 21;
        gp.monster[2].worldY = gp.tileSize * 88;
    }

}
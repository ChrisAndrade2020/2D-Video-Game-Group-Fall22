package main;

import object.ObjectBed1;
import object.ObjectBed2;
import object.ObjectChestClosedArmor;
import object.ObjectChestClosedBoots;
import object.ObjectChestClosedSword;
import object.ObjectCrate;
import object.ObjectDoorClosed;
import object.ObjectKeyGold;
import object.ObjectKeyIron;
import object.ObjectLog1;
import object.ObjectLog2;
import object.ObjectStump1;
import object.ObjectStump2;
import object.ObjectStump3;
import object.ObjectStump4;

// this class will handle the object placement on the map. Since we will be placing placing multiple objects on the map

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;

    }

    public void setObject() {

        gp.obj[0] = new ObjectKeyGold(gp);
        gp.obj[0].worldX = 1 * gp.tileSize;
        gp.obj[0].worldY = 3 * gp.tileSize;

        gp.obj[1] = new ObjectKeyGold(gp);
        gp.obj[1].worldX = 38 * gp.tileSize;
        gp.obj[1].worldY = 29 * gp.tileSize;

        gp.obj[2] = new ObjectKeyGold(gp);
        gp.obj[2].worldX = 5 * gp.tileSize;
        gp.obj[2].worldY = 36 * gp.tileSize;

        gp.obj[3] = new ObjectKeyIron(gp);
        gp.obj[3].worldX = 35 * gp.tileSize;
        gp.obj[3].worldY = 2 * gp.tileSize;

        gp.obj[4] = new ObjectDoorClosed(gp);
        gp.obj[4].worldX = 8 * gp.tileSize;
        gp.obj[4].worldY = 14 * gp.tileSize;

        gp.obj[5] = new ObjectChestClosedBoots(gp);
        gp.obj[5].worldX = 9 * gp.tileSize;
        gp.obj[5].worldY = 9 * gp.tileSize;

        gp.obj[6] = new ObjectChestClosedArmor(gp);
        gp.obj[6].worldX = 8 * gp.tileSize;
        gp.obj[6].worldY = 9 * gp.tileSize;

        gp.obj[7] = new ObjectChestClosedSword(gp);
        gp.obj[7].worldX = 7 * gp.tileSize;
        gp.obj[7].worldY = 9 * gp.tileSize;

        gp.obj[8] = new ObjectStump1(gp);
        gp.obj[8].worldX = 18 * gp.tileSize;
        gp.obj[8].worldY = 9 * gp.tileSize;

        gp.obj[9] = new ObjectStump2(gp);
        gp.obj[9].worldX = 19 * gp.tileSize;
        gp.obj[9].worldY = 9 * gp.tileSize;

        gp.obj[10] = new ObjectStump3(gp);
        gp.obj[10].worldX = 18 * gp.tileSize;
        gp.obj[10].worldY = 10 * gp.tileSize;

        gp.obj[11] = new ObjectStump4(gp);
        gp.obj[11].worldX = 19 * gp.tileSize;
        gp.obj[11].worldY = 10 * gp.tileSize;

        gp.obj[12] = new ObjectLog1(gp);
        gp.obj[12].worldX = 3 * gp.tileSize;
        gp.obj[12].worldY = 13 * gp.tileSize;

        gp.obj[13] = new ObjectLog2(gp);
        gp.obj[13].worldX = 4 * gp.tileSize;
        gp.obj[13].worldY = 13 * gp.tileSize;

        gp.obj[14] = new ObjectBed1(gp);
        gp.obj[14].worldX = 4 * gp.tileSize;
        gp.obj[14].worldY = 9 * gp.tileSize;

        gp.obj[15] = new ObjectBed2(gp);
        gp.obj[15].worldX = 4 * gp.tileSize;
        gp.obj[15].worldY = 10 * gp.tileSize;

        gp.obj[16] = new ObjectCrate(gp);
        gp.obj[16].worldX = 4 * gp.tileSize;
        gp.obj[16].worldY = (int) (10.5 * gp.tileSize); // casted as int to better suit world placement

        // gp.obj[17] = new ObjectLog2();
        // gp.obj[17].worldX = 4 * gp.tileSize;
        // gp.obj[17].worldY = 13 * gp.tileSize;

        // gp.obj[18] = new ObjectLog2();
        // gp.obj[18].worldX = 4 * gp.tileSize;
        // gp.obj[18].worldY = 13 * gp.tileSize;

        // gp.obj[19] = new ObjectLog2();
        // gp.obj[19].worldX = 4 * gp.tileSize;
        // gp.obj[19].worldY = 13 * gp.tileSize;

        // gp.obj[20] = new ObjectLog2();
        // gp.obj[20].worldX = 4 * gp.tileSize;
        // gp.obj[20].worldY = 13 * gp.tileSize;

        // gp.obj[21] = new ObjectLog2();
        // gp.obj[21].worldX = 4 * gp.tileSize;
        // gp.obj[21].worldY = 13 * gp.tileSize;

        // gp.obj[22] = new ObjectLog2();
        // gp.obj[22].worldX = 4 * gp.tileSize;
        // gp.obj[22].worldY = 13 * gp.tileSize;

        // gp.obj[23] = new ObjectLog2();
        // gp.obj[23].worldX = 4 * gp.tileSize;
        // gp.obj[23].worldY = 13 * gp.tileSize;

        // gp.obj[24] = new ObjectLog2();
        // gp.obj[24].worldX = 4 * gp.tileSize;
        // gp.obj[24].worldY = 13 * gp.tileSize;

    }

}

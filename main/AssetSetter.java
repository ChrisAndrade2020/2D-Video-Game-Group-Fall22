package main;

import object.ObjectChestClosedArmor;
import object.ObjectChestClosedBoots;
import object.ObjectChestClosedSword;
import object.ObjectDoorClosed;
import object.ObjectKeyGold;
import object.ObjectKeyIron;
import object.ObjectLog1;
import object.ObjectLog2;
import object.ObjectStump;

// this class will handle the object placement on the map. Since we will be placing placing multiple objects on the map

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;

    }

    public void setObject() {

        gp.obj[0] = new ObjectKeyGold();
        gp.obj[0].worldX = 1 * gp.tileSize;
        gp.obj[0].worldY = 3 * gp.tileSize;

        gp.obj[1] = new ObjectKeyGold();
        gp.obj[1].worldX = 38 * gp.tileSize;
        gp.obj[1].worldY = 29 * gp.tileSize;

        gp.obj[2] = new ObjectKeyGold();
        gp.obj[2].worldX = 5 * gp.tileSize;
        gp.obj[2].worldY = 36 * gp.tileSize;

        gp.obj[3] = new ObjectKeyIron();
        gp.obj[3].worldX = 19 * gp.tileSize;
        gp.obj[3].worldY = 9 * gp.tileSize;

        gp.obj[4] = new ObjectDoorClosed();
        gp.obj[4].worldX = 8 * gp.tileSize;
        gp.obj[4].worldY = 14 * gp.tileSize;

        gp.obj[5] = new ObjectChestClosedBoots();
        gp.obj[5].worldX = 9 * gp.tileSize;
        gp.obj[5].worldY = 9 * gp.tileSize;

        gp.obj[6] = new ObjectChestClosedArmor();
        gp.obj[6].worldX = 8 * gp.tileSize;
        gp.obj[6].worldY = 9 * gp.tileSize;

        gp.obj[7] = new ObjectChestClosedSword();
        gp.obj[7].worldX = 7 * gp.tileSize;
        gp.obj[7].worldY = 9 * gp.tileSize;

        gp.obj[8] = new ObjectStump();
        gp.obj[8].worldX = 19 * gp.tileSize;
        gp.obj[8].worldY = 10 * gp.tileSize;

        gp.obj[9] = new ObjectLog1();
        gp.obj[9].worldX = 3 * gp.tileSize;
        gp.obj[9].worldY = 13 * gp.tileSize;

        gp.obj[10] = new ObjectLog2();
        gp.obj[10].worldX = 4 * gp.tileSize;
        gp.obj[10].worldY = 13 * gp.tileSize;

    }

}

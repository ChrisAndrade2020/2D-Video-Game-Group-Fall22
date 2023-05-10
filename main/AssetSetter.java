package main;

import object.ObjectChest;
import object.ObjectDoorClosed;
import object.ObjectSword;

// this class will handle the object placement on the map. Since we will be placing placing multiple objects on the map

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;

    }

    public void setObject() {

        gp.obj[0] = new ObjectSword();
        gp.obj[0].worldX = 15 * gp.tileSize;
        gp.obj[0].worldY = 15 * gp.tileSize;

        gp.obj[1] = new ObjectSword();
        gp.obj[1].worldX = 16 * gp.tileSize;
        gp.obj[1].worldY = 16 * gp.tileSize;

        gp.obj[2] = new ObjectDoorClosed();
        gp.obj[2].worldX = 8 * gp.tileSize;
        gp.obj[2].worldY = 14 * gp.tileSize;

        gp.obj[3] = new ObjectDoorClosed();
        gp.obj[3].worldX = 17 * gp.tileSize;
        gp.obj[3].worldY = 18 * gp.tileSize;

        gp.obj[4] = new ObjectDoorClosed();
        gp.obj[4].worldX = 25 * gp.tileSize;
        gp.obj[4].worldY = 25 * gp.tileSize;

        gp.obj[5] = new ObjectChest();
        gp.obj[5].worldX = 9 * gp.tileSize;
        gp.obj[5].worldY = 9 * gp.tileSize;

    }

}

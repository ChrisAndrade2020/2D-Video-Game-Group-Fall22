package main;

import object.ObjectSword;

// this class will handle the object placement on the map. Since we will be placing placing multiple objects on the map

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;

    }

    public void setObject() {

        gp.obj[0] = new ObjectSword();
        gp.obj[0].worldX = 9 * gp.tileSize;
        gp.obj[0].worldY = 9 * gp.tileSize;

    }

}

package object;

import entity.Entity;
import main.GamePanel;

public class ObjectCrate extends Entity {

    public ObjectCrate(GamePanel gp) {
        super(gp);

        name = "Crate";
        direction = "down";
        pd_1 = setup("/res/objects/crate");
        collision = true;

    }

}

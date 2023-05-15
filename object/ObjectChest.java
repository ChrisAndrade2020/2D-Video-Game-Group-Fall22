package object;

import entity.Entity;
import main.GamePanel;

public class ObjectChest extends Entity {

    public ObjectChest(GamePanel gp) {
        super(gp);

        name = "Chest";
        pd_1 = setup("/res/objects/chest1");
        collision = true;

    }

}

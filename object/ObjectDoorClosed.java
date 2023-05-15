package object;

import entity.Entity;
import main.GamePanel;

public class ObjectDoorClosed extends Entity {

    public ObjectDoorClosed(GamePanel gp) {
        super(gp);

        name = "DoorClosed";
        pd_1 = setup("/res/objects/door_world_0");
        collision = true;
    }

}

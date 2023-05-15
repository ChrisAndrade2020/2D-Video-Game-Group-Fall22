package object;

import entity.Entity;
import main.GamePanel;

public class ObjectDoorOpen extends Entity {

    public ObjectDoorOpen(GamePanel gp) {
        super(gp);

        name = "DoorOpen";
        down1 = setup("/res/objects/door_world_1");

    }

}

package object;

import entity.Entity;
import main.GamePanel;

public class ObjectDoorClosed extends Entity {

    public ObjectDoorClosed(GamePanel gp) {
        super(gp);

        direction = "down";
        name = "DoorClosed";
        pd_1 = setup("/res/objects/door_world_0");
        collision = true;

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

}

package object;

import entity.Entity;
import main.GamePanel;

public class ObjectDoorClosed extends Entity {

    public ObjectDoorClosed(GamePanel gp) {
        super(gp);

        System.out.println("ObjectDoorClosed created, image is " + (pd_1 != null ? "not null" : "null"));

        direction = "down";
        name = "DoorClosed";
        down1 = setup("/res/objects/door_world_0");
        collision = true;

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

}

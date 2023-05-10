package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectDoorOpen extends SuperObject {

    public ObjectDoorOpen() {

        name = "DoorOpen";

        try {

            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door_world_1.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = false;

    }

}
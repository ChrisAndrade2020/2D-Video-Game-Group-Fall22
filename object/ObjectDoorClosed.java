package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectDoorClosed extends SuperObject {

    public ObjectDoorClosed() {

        name = "DoorClosed";

        try {

            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door_world_0.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}

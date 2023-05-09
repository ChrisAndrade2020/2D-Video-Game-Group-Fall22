package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectDoor extends SuperObject {

    public ObjectDoor() {

        name = "Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door_world_0.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
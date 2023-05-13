package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectDoorOpen extends SuperObject {

    public ObjectDoorOpen(GamePanel gp) {

        name = "DoorOpen";

        try {

            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door_world_1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = false;

    }

}
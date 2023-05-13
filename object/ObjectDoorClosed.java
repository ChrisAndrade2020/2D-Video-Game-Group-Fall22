package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectDoorClosed extends SuperObject {

    public ObjectDoorClosed(GamePanel gp) {

        name = "DoorClosed";

        try {

            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door_world_0.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}

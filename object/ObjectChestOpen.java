package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectChestOpen extends SuperObject {

    public ObjectChestOpen() {

        name = "ChestOpen";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest4.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}

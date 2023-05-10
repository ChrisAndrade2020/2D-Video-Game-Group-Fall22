package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectChestClosedBoots extends SuperObject {

    public ObjectChestClosedBoots() {

        name = "ChestBoots";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest1.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
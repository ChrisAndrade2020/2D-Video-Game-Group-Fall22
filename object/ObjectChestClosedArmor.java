package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectChestClosedArmor extends SuperObject {

    public ObjectChestClosedArmor() {

        name = "ChestArmor";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest1.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
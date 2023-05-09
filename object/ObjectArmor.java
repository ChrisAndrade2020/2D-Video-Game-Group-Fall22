package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectArmor extends SuperObject {

    public ObjectArmor() {

        name = "Armor";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/armor.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
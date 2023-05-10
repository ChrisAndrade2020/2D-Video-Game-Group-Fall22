package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectSword extends SuperObject {

    public ObjectSword() {

        name = "Sword";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/sword.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}

package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectKeyIron extends SuperObject {

    public ObjectKeyIron() {

        name = "Iron Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key_iron.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
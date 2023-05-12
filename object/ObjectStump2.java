package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectStump2 extends SuperObject {

    public ObjectStump2() {

        name = "Stump";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/stump_2.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
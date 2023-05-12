package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectStump4 extends SuperObject {

    public ObjectStump4() {

        name = "Stump";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/stump_4.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
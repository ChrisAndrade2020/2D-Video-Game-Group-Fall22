package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectStump3 extends SuperObject {

    public ObjectStump3() {

        name = "Stump";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/stump_3.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
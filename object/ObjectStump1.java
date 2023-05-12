package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectStump1 extends SuperObject {

    public ObjectStump1() {

        name = "Stump";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/stump_1.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
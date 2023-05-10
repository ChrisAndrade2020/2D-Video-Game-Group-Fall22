package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectStump extends SuperObject {

    public ObjectStump() {

        name = "Stump";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/stump.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
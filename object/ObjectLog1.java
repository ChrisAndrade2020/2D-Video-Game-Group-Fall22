package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectLog1 extends SuperObject {

    public ObjectLog1() {

        name = "Log";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/log_mossy_1.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
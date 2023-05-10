package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectLog2 extends SuperObject {

    public ObjectLog2() {

        name = "Log2";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/log_mossy_2.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
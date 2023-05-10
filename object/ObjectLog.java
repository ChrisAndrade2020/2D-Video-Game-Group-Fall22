package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectLog extends SuperObject {

    public ObjectLog() {

        name = "Log";

        width = width * 2;

        solidArea.width = width;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/log_mossy.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectBed1 extends SuperObject {

    public ObjectBed1() {

        name = "Bed1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/bed_1.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectBed2 extends SuperObject {

    public ObjectBed2() {

        name = "Bed2";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/bed_2.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
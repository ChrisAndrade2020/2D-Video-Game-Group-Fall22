package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectCrate extends SuperObject {

    public ObjectCrate() {

        name = "Crate";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/crate.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
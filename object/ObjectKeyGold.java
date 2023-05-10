package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectKeyGold extends SuperObject {

    public ObjectKeyGold() {

        name = "Gold Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key_gold.png"));
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
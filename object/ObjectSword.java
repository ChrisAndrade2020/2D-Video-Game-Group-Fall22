package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectSword extends SuperObject {

    public ObjectSword(GamePanel gp) {

        name = "Sword";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/sword.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}

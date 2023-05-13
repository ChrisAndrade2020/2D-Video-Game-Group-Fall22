package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectKeyIron extends SuperObject {

    public ObjectKeyIron(GamePanel gp) {

        name = "Iron Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key_iron.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
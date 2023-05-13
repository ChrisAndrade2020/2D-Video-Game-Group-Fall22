package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectBoots extends SuperObject {

    public ObjectBoots(GamePanel gp) {

        name = "Boots";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/boots.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}

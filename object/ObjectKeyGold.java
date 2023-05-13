package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectKeyGold extends SuperObject {

    public ObjectKeyGold(GamePanel gp) {

        name = "Gold Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key_gold.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
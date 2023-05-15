package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectHeart extends SuperObject {

    public ObjectHeart(GamePanel gp) {

        name = "Heart";

        try {

            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/heart_full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/heart_border.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/objects/heart_empty.png"));
            image = tool.scaledImage(image, gp.tileSize, gp.tileSize);
            image2 = tool.scaledImage(image2, gp.tileSize, gp.tileSize);
            image3 = tool.scaledImage(image3, gp.tileSize, gp.tileSize);

        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = false;

    }

}
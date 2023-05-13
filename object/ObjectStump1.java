package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectStump1 extends SuperObject {

    public ObjectStump1(GamePanel gp) {

        name = "Stump";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/stump_1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
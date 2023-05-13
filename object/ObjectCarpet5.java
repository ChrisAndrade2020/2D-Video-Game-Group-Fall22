package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectCarpet5 extends SuperObject {

    public ObjectCarpet5(GamePanel gp) {

        name = "Carpet5";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/carpet_2.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
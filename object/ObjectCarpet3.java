package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectCarpet3 extends SuperObject {

    public ObjectCarpet3(GamePanel gp) {

        name = "Carpet3";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/carpet_7.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
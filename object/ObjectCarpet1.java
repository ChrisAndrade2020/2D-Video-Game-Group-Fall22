package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectCarpet1 extends SuperObject {

    public ObjectCarpet1(GamePanel gp) {

        name = "Carpet1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/carpet_1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
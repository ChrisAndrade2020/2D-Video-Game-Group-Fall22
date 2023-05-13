package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectCarpet6 extends SuperObject {

    public ObjectCarpet6(GamePanel gp) {

        name = "Carpet6";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/carpet_8.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
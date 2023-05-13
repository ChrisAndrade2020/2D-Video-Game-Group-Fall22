package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectCarpet2 extends SuperObject {

    public ObjectCarpet2(GamePanel gp) {

        name = "Carpet2";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/carpet_3.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
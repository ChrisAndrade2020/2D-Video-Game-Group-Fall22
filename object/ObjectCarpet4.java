package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectCarpet4 extends SuperObject {

    public ObjectCarpet4(GamePanel gp) {

        name = "Carpet4";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/carpet_9.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
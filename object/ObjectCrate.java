package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectCrate extends SuperObject {

    public ObjectCrate(GamePanel gp) {

        name = "Crate";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/crate.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
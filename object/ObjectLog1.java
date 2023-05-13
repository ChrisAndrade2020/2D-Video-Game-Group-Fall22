package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectLog1 extends SuperObject {

    public ObjectLog1(GamePanel gp) {

        name = "Log1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/log_mossy_1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
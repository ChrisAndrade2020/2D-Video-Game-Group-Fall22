package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectLog2 extends SuperObject {

    public ObjectLog2(GamePanel gp) {

        name = "Log2";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/log_mossy_2.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
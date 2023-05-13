package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectTable1 extends SuperObject {

    public ObjectTable1(GamePanel gp) {

        name = "Table1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/table_1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;
    }

}
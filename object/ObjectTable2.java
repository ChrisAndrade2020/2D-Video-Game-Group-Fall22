package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectTable2 extends SuperObject {

    public ObjectTable2(GamePanel gp) {

        name = "Table2";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/table_2.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;
    }

}
package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectBookshelf2 extends SuperObject {

    public ObjectBookshelf2(GamePanel gp) {

        name = "Bookshelf2";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/bookshelf_2.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;
    }

}
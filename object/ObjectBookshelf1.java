package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectBookshelf1 extends SuperObject {

    public ObjectBookshelf1(GamePanel gp) {

        name = "Bookshelf1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/bookshelf_1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;
    }

}
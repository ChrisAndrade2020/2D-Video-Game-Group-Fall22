package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectBed2 extends SuperObject {

    public ObjectBed2(GamePanel gp) {

        name = "Bed2";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/bed_2.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
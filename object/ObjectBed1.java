package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectBed1 extends SuperObject {

    public ObjectBed1(GamePanel gp) {

        name = "Bed1";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/bed_1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
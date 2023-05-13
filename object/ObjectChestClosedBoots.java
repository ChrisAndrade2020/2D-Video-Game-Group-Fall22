package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectChestClosedBoots extends SuperObject {

    public ObjectChestClosedBoots(GamePanel gp) {

        name = "ChestBoots";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
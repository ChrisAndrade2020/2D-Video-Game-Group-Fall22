package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectChestClosedArmor extends SuperObject {

    public ObjectChestClosedArmor(GamePanel gp) {

        name = "ChestArmor";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest1.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

        collision = true;

    }

}
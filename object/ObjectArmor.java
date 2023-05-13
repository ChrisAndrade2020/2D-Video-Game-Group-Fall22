package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectArmor extends SuperObject {

    public ObjectArmor(GamePanel gp) {

        name = "Armor";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/armor.png"));
            tool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
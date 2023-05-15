package object;

import entity.Entity;
import main.GamePanel;

public class ObjectSword extends Entity {

    public ObjectSword(GamePanel gp) {
        super(gp);

        direction = "down";
        name = "Sword";
        down1 = setup("/res/objects/sword");

    }

}

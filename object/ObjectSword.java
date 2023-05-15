package object;

import entity.Entity;
import main.GamePanel;

public class ObjectSword extends Entity {

    public ObjectSword(GamePanel gp) {
        super(gp);

        name = "Sword";
        pd_1 = setup("/res/objects/sword");

    }

}

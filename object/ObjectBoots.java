package object;

import entity.Entity;
import main.GamePanel;

public class ObjectBoots extends Entity {

    public ObjectBoots(GamePanel gp) {
        super(gp);

        name = "Boots";
        pd_1 = setup("/res/objects/boots");

    }

}

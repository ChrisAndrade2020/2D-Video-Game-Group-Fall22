package object;

import entity.Entity;
import main.GamePanel;

public class ObjectArmor extends Entity {

    public ObjectArmor(GamePanel gp) {
        super(gp);
        name = "Armor";
        pd_1 = setup("/res/objects/armor");

    }

}

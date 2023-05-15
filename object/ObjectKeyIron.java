package object;

import entity.Entity;
import main.GamePanel;

public class ObjectKeyIron extends Entity {

    public ObjectKeyIron(GamePanel gp) {
        super(gp);

        name = "IKey";
        pd_1 = setup("/res/objects/key_iron");

    }

}
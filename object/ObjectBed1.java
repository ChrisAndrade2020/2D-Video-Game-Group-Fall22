package object;

import entity.Entity;
import main.GamePanel;

public class ObjectBed1 extends Entity {

    public ObjectBed1(GamePanel gp) {
        super(gp);

        name = "Bed1";
        pd_1 = setup("/res/objects/bed_1");
        collision = true;

    }

}

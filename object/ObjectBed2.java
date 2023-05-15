package object;

import entity.Entity;
import main.GamePanel;

public class ObjectBed2 extends Entity {

    public ObjectBed2(GamePanel gp) {
        super(gp);

        name = "Bed2";
        direction = "down";
        down1 = setup("/res/objects/bed_2");
        collision = true;

    }

}

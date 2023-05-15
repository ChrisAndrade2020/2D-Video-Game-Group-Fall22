package object;

import entity.Entity;
import main.GamePanel;

public class ObjectHeart extends Entity {

    public ObjectHeart(GamePanel gp) {

        super(gp);

        name = "Heart";

        image = setup("/res/objects/heart_full");
        image2 = setup("/res/objects/heart_border");
        image3 = setup("/res/objects/heart_empty");
    }
}
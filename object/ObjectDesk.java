package object;

import entity.Entity;
import main.GamePanel;

public class ObjectDesk extends Entity {

    public ObjectDesk(GamePanel gp) {
        super(gp);

        name = "Desk";
        down1 = setup("/res/objects/desk");
        collision = true;

    }

}

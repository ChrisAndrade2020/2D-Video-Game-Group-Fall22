package object;

import entity.Entity;
import main.GamePanel;

public class ObjectBoots extends Entity {

    public ObjectBoots(GamePanel gp) {
        super(gp);

        name = "Boots";
        down1 = setup("/res/objects/boots");

        gp.player.speed += 2;

    }

}

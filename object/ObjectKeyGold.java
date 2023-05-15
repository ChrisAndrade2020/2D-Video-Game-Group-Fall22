package object;

import entity.Entity;
import main.GamePanel;

public class ObjectKeyGold extends Entity {

    public ObjectKeyGold(GamePanel gp) {
        super(gp);

        name = "GKey";
        direction = "down";
        down1 = setup("/res/objects/key_gold");

        gp.player.keyGold++;

    }

}
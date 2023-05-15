package object;

import entity.Entity;
import main.GamePanel;

public class ObjectKeyIron extends Entity {

    public ObjectKeyIron(GamePanel gp) {
        super(gp);

        name = "IKey";
        direction = "down";
        down1 = setup("/res/objects/key_iron");

        gp.player.keyIron++;

    }

}
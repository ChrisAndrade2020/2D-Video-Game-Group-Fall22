package object;

import entity.Entity;
import main.GamePanel;

public class ObjectBookshelf1 extends Entity {

    public ObjectBookshelf1(GamePanel gp) {
        super(gp);

        name = "Shelf1";
        pd_1 = setup("/res/objects/bookshelf_1");
        collision = true;

    }

}

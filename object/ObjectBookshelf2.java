package object;

import entity.Entity;
import main.GamePanel;

public class ObjectBookshelf2 extends Entity {

    public ObjectBookshelf2(GamePanel gp) {
        super(gp);

        name = "Shelf2";
        pd_1 = setup("/res/objects/bookshelf_2");
        collision = true;

    }

}

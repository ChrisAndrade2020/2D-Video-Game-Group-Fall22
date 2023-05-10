package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;

    public BufferedImage

    pi_1, pi_2, pi_3, pi_4, pi_5, pi_6,
            pu_1, pu_2, pu_3, pu_4, pu_5, pu_6,
            pd_1, pd_2, pd_3, pd_4, pd_5, pd_6,
            pl_1, pl_2, pl_3, pl_4, pl_5, pl_6,
            pr_1, pr_2, pr_3, pr_4, pr_5, pr_6,
            wi1, wi2, wi3, wi4, wi5, wi6, wwr1,
            wwr2, wwr3, wwr4, wwr5, wwr6, wwl1,
            wwl2, wwl3, wwl4, wwl5, wwl6;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn = true;

}

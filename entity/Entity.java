package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;

public class Entity {

    protected GamePanel gp;

    public int worldX, worldY;
    public int speed;

    public BufferedImage pi_1, pi_2, pi_3, pi_4, pi_5, pi_6,
            pu_1, pu_2, pu_3, pu_4, pu_5, pu_6,
            pd_1, pd_2, pd_3, pd_4, pd_5, pd_6,
            pl_1, pl_2, pl_3, pl_4, pl_5, pl_6,
            pr_1, pr_2, pr_3, pr_4, pr_5, pr_6,
            slime_idle1, slime_idle2, slime_idle3, slime_idle4, slime_idle5, slime_idle6,
            slime_move1, slime_move2, slime_move3, slime_move4, slime_move5, slime_move6;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn = false;

    protected boolean collisionSFXPlayed = false;
    protected boolean messageDisplayed = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

}

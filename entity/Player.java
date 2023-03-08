package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();

    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;

    }

    public void update() {

        if (keyH.up == true) {
            y -= speed;
        }

        else if (keyH.down == true) {
            y += speed;
        } else if (keyH.left == true) {
            x -= speed;
        } else if (keyH.right == true) {
            x += speed;
        }

    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.WHITE);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

    }

}

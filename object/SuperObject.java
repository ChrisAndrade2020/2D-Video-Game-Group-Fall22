package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

// pretty much just the what the entity class is to the player class
public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D g2, GamePanel gp) {

        // very similar to tile manager drawing the tiles

        double screenX = worldX - gp.player.worldX + gp.player.screenX;
        double screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + (gp.tileSize) > gp.player.worldX - gp.player.screenX &&
                worldX - (gp.tileSize * 3) < gp.player.worldX + gp.player.screenX &&
                worldY + (gp.tileSize) > gp.player.worldY - gp.player.screenY &&
                worldY - (gp.tileSize * 3) < gp.player.worldY + gp.player.screenY) {

            g2.drawImage(image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);

        }

    }

}

package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[90];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/maps/worldmap1.txt");

    }

    public void getTileImage() {

        // getting tile images

        try {

            tile[00] = new Tile();
            tile[00].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/elevated_8.png"));
            // no need to add collision because it is false by default. refer to tile class

            tile[01] = new Tile();
            tile[01].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/rocks_8.png"));

            tile[02] = new Tile();
            tile[02].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));

            tile[03] = new Tile();
            tile[03].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/plains_8.png"));

            tile[04] = new Tile();
            tile[04].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/fences_12.png"));
            tile[04].collision = true;

            tile[05] = new Tile();
            tile[05].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water1_7.png"));
            tile[05].collision = true;

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;

                    col++;
                }

                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }

            }

            br.close();

        } catch (Exception e) {

        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize; // world coordinates are the coordinates in the world map, whereas
                                                 // screen coordinates are where we're going to draw the tile on the
                                                 // screen.
            int worldY = worldRow * gp.tileSize;

            double screenX = worldX - gp.player.worldX + gp.player.screenX;
            double screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + (gp.tileSize) > gp.player.worldX - gp.player.screenX &&
                    worldX - (gp.tileSize * 3) < gp.player.worldX + gp.player.screenX &&
                    worldY + (gp.tileSize) > gp.player.worldY - gp.player.screenY &&
                    worldY - (gp.tileSize * 3) < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);

            }

            // This if statement makes it so we don't draw tiles that aren't on the screen

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;

            }

        }

    }

}

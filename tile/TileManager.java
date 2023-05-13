package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

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

            setup(0, "elevated_8", false);
            setup(1, "rocks_8", false);
            setup(2, "grass", false);
            setup(3, "plains_8", false);
            setup(4, "fences_12", true);
            setup(5, "water1_7", true);
            setup(6, "walls_1", true);
            setup(7, "walls_2", true);
            setup(10, "walls_3", true);
            setup(11, "walls_20", true);
            setup(12, "walls_21", true);
            setup(13, "walls_22", true);
            setup(14, "walls_7", true);
            setup(15, "walls_8", true);
            setup(16, "walls_12", true);
            setup(17, "walls_14", true);
            setup(18, "wooden", false);
            setup(19, "walls_5", true);
            setup(20, "walls_7_wall", true);
            setup(21, "walls_8_wall", true);
            setup(22, "walls_11", true);
            setup(23, "walls_8_floor", true);
            setup(24, "walls_1_floor", true);
            setup(25, "walls_2_floor", true);
            setup(26, "walls_3_floor", true);
            setup(27, "walls_14_floor", true);
            setup(28, "walls_12_floor", true);
            setup(29, "walls_14_floor", true);
            setup(30, "walls_5_floor", true);
            setup(31, "walls_1_grass", true);
            setup(32, "walls_2_grass", true);
            setup(33, "walls_3_grass", true);
            setup(34, "walls_2_floor_header", false);
            setup(35, "walls_3_floor", true);

        }

        finally {

            // I do not know why my IDE forces me to have this block. I believe that this
            // block is optional?

        }

    }

    public void setup(int index, String imagePath, boolean collision) {

        UtilityTool tool = new UtilityTool();

        try {

            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/" + imagePath + ".png"));
            tile[index].image = tool.scaledImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

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
                    worldX - (gp.tileSize * 4) < gp.player.worldX + gp.player.screenX &&
                    worldY + (gp.tileSize) > gp.player.worldY - gp.player.screenY &&
                    worldY - (gp.tileSize * 4) < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);

                // g2.setColor(Color.yellow);
                // g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width,
                // solidArea.height);

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

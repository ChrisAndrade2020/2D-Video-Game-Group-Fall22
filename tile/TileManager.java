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

            tile[06] = new Tile();
            tile[06].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_1.png"));
            tile[06].collision = true;

            tile[07] = new Tile();
            tile[07].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_2.png"));
            tile[07].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_3.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_20.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_21.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_22.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_7.png"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_8.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_12.png"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_14.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wooden.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_5.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_7_wall.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_8_wall.png"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_11.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_8_floor.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_1_floor.png"));
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_2_floor.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_3_floor.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_14_floor.png"));
            tile[27].collision = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_12_floor.png"));
            tile[28].collision = true;

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_14_floor.png"));
            tile[29].collision = true;

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_5_floor.png"));
            tile[30].collision = true;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_1_grass.png"));
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_2_grass.png"));
            tile[32].collision = true;

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_3_grass.png"));
            tile[33].collision = true;

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_2_floor_header.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/walls_3_floor.png"));
            tile[35].collision = true;

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

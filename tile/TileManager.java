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
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[45];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/maps/worldmap1.txt");

    }

    public void getTileImage() {

        try {

            tile[00] = new Tile();
            tile[00].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock1.png"));

            tile[01] = new Tile();
            tile[01].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock2.png"));

            tile[02] = new Tile();
            tile[02].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock3.png"));

            tile[03] = new Tile();
            tile[03].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock4.png"));

            tile[04] = new Tile();
            tile[04].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock5.png"));

            tile[05] = new Tile();
            tile[05].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock6.png"));

            tile[06] = new Tile();
            tile[06].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock7.png"));

            tile[07] = new Tile();
            tile[07].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock8.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock9.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Wall1.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Wall2.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Wall3.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Stair1.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Stair2.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Stair3.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Shadow_Top.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Rock_Flat1.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Rock_Flat_Thin5.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Rock_Flat3.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Rock_Flat_Thin2.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Rock_Flat7.png"));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Rock_Flat9.png"));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Rock_Flat_Thin4.png"));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Rock_Flat_Thin2.png"));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Stair1.png"));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Stair2.png"));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Stair3.png"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Stair1.png"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Stair2.png"));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock_Shadow4.png"));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Rock_Shadow6.png"));

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Shadow4.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand_Shadow6.png"));

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand7.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand8.png"));

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Sand9.png"));

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Wall1.png"));

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Wall2.png"));

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Wall3.png"));

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Shadow_Top.png"));

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Shadow_Left.png"));

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Shadow_Right.png"));

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass_Wall3.png"));

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

            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + (gp.tileSize) > gp.player.worldX - gp.player.screenX &&
                    worldX - (gp.tileSize * 3) < gp.player.worldX + gp.player.screenX &&
                    worldY + (gp.tileSize) > gp.player.worldY - gp.player.screenY &&
                    worldY - (gp.tileSize * 3) < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

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

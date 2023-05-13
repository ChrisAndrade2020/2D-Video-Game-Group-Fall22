package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    ArrayList<String> fileNames = new ArrayList<>();
    ArrayList<String> collisionStatus = new ArrayList<>();

    public TileManager(GamePanel gp) {

        this.gp = gp;

        // to read files
        InputStream is = getClass().getResourceAsStream("/res/maps/bigMapCollision.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        // getting tile names and collision info from files
        String line;

        try {
            while ((line = br.readLine()) != null) {

                fileNames.add(line);
                collisionStatus.add(br.readLine());

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tile = new Tile[fileNames.size()];
        getTileImage();

        // geting maxWorld Col & Row
        is = getClass().getResourceAsStream("/res/maps/bigmap.txt");
        br = new BufferedReader(new InputStreamReader(is));

        try {

            String line2 = br.readLine();
            String maxTile[] = line2.split(" ");

            gp.maxWorldCol = maxTile.length;
            gp.maxWorldRow = maxTile.length;

            mapTileNum = new int[gp.MaxMap][gp.maxWorldCol][gp.maxWorldRow];

            br.close();

            gp.maxWorldCol = maxTile.length;
        } catch (IOException e) {
            System.out.println("Exception!");
        }

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/maps/worldmap1.txt");

    }

    public void getTileImage() {

        for (int i = 0; i < fileNames.size(); i++) {

            String fileName;
            boolean collision;

            // getting file name
            fileName = fileNames.get(i);

            // getting collision status
            if (collisionStatus.get(i).equals("true")) {
                collision = true;
            } else {
                collision = false;
            }

            setup(i, fileName, collision);

        }

    }

    public void setup(int index, String imagePath, boolean collision) {

        UtilityTool tool = new UtilityTool();

        try {

            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/" + imagePath));
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

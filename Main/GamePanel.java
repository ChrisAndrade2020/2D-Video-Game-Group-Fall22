package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    // Screen Settings
    final int originalTileSize = 16; // 16x16 common pixel size
    final int scale = 3;
    final int pscale = 9;
    final int escale = 12;

    public int tileSize = originalTileSize * scale; // size of tiles
    public int playerSize = originalTileSize * pscale; // size of player
    public int entitySize = originalTileSize * escale; // size of other entities

    public final int maxScreenCol = 32;
    public final int maxScreenRow = 18;

    public int screenWidth = tileSize * maxScreenCol;
    public int screenHeight = tileSize * maxScreenRow;

    // World Map Settings

    public final int maxWorldCol = 40;
    public final int maxWorldRow = 40;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    Thread gameThread; // automatically calls the run method
    public Player player = new Player(this, keyH);

    // default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true); // So gamePanel can focus on the user inputs

    }

    // Too many problems arise when trying to add a zoom in and out feature
    // Need to change player speed, need to cast some ints to doubles, need to
    // reposition the player based off of the new dimensions, etc.
    // Commented out.

    // public void zoomScreen(int i) {

    // int oldWorldWidth = tileSize * maxWorldCol; // 1920

    // tileSize += i;
    // playerSize += 6 * i;
    // entitySize += 9 * i;

    // int newWorldWidth = tileSize * maxWorldCol; // 1880

    // double multiplier = (double) newWorldWidth / oldWorldWidth;

    // System.out.println("tileSize:" + tileSize);
    // System.out.println("worldWidth:" + newWorldWidth);

    // double newPlayerWorldX = player.worldX * multiplier;
    // double newPlayerWorldY = player.worldY * multiplier;

    // player.worldX = (int) newPlayerWorldX;
    // player.worldY = (int) newPlayerWorldY;

    // }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        /*
         * using nano-seconds because its more precise vs milliseconds, which is also
         * another option.
         * roughly equivalent to 16.67 milliseconds;
         */

        double nextDrawTime = System.nanoTime() + drawInterval; // telling the computer to draw at 16.67ms intervals

        while (gameThread != null) {

            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000; // converting nano to milliseonds

                if (remainingTime < 0) {

                    remainingTime = 0;

                }

                Thread.sleep((long) remainingTime); // only accepts milliseconds

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                //
                e.printStackTrace();
            }

        }

    }

    public void update() {

        player.update();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2); // tile first before player entity, otherwise player will be drawn BEHIND the
                        // tile and won't be seen.
        player.draw(g2);

        g2.dispose(); // apparently good practice to save memory. Might not matter too much with
                      // systems having 16GB or more nowadays.

    }
}

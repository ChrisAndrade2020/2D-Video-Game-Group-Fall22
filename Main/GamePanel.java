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
    final int scale = 4;
    final int pscale = 12;
    final int escale = 12;

    public final int tileSize = originalTileSize * scale; // size of tiles
    public final int playerSize = originalTileSize * pscale; // size of player
    public final int entitySize = originalTileSize * escale; // size of other entities

    public final int maxScreenCol = 30;
    public final int maxScreenRow = 16;

    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // automatically calls the run method
    Player player = new Player(this, keyH);

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

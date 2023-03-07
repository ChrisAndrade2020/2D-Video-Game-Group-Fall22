package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    // Screen Settings
    final int originalTileSize = 16; // 16x16 pixel size
    final int scale = 4;

    final int tileSize = originalTileSize * scale; // scales up 16x16 to 64 for easier viewing on modern 1080p screens

    final int maxScreenCol = 24;
    final int maxScreenRow = 16;

    final int screenWidth = tileSize * maxScreenCol; // 1536px across
    final int screenHeight = tileSize * maxScreenRow; // 1024px tall

    int FPS = 60;

    Input input = new Input();
    Thread gameThread; // automatically calls the run method

    // default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
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

        if (input.up == true) {
            playerY -= playerSpeed;
        }

        if (input.down == true) {
            playerY += playerSpeed;
        }
        if (input.left == true) {
            playerX -= playerSpeed;
        }
        if (input.right == true) {
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose(); // apparently good practice to save memory. Might not matter too much with
                      // systems having 16GB or more nowadays.

    }
}

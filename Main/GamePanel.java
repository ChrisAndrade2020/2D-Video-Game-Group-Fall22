package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import entity.Entity;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;
    final int pscale = 9;
    final int escale = 6;

    public int tileSize = originalTileSize * scale;
    public int playerSize = originalTileSize * pscale;
    public int entitySize = originalTileSize * escale;

    public final int maxScreenCol = 15;
    public final int maxScreenRow = 10;

    public int screenWidth = tileSize * maxScreenCol;
    public int screenHeight = tileSize * maxScreenRow;

    public int maxWorldCol;
    public int maxWorldRow;

    public final int worldWidth = tileSize * 100;
    public final int worldHeight = tileSize * 100;

    int FPS = 60;

    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);

    Sounds music = new Sounds();
    Sounds sfx = new Sounds();

    public EventHandler eHandler = new EventHandler(this);

    Thread gameThread;

    public Player player = new Player(this, keyH);
    public Entity obj[] = new Entity[100];
    public Entity npc[] = new Entity[100];
    public Entity monster[] = new Entity[100];
    ArrayList<Entity> entityList = new ArrayList<>();

    public String objectName;

    public int gameState;
    public final int titleState = 0; // title screen
    public final int playState = 1; // game running
    public final int pauseState = 2; // game paused
    public final int dialogueState = 3; // when dialogue happens

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    // Sets up the game
    public void setupGame() {

        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        // playMusic(0);

        gameState = titleState;
    }

    // Starts the game thread
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Handles game update and draw timing
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            update();
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Updates the game state
    public void update() {
        if (gameState == playState) {
            player.update();

            // Clear the list at the start of each update
            entityList.clear();

            // Always add the player to the list
            entityList.add(player);

            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                    // Add the updated npc to the list
                    entityList.add(npc[i]);
                }
            }

            for (int i = 0; i < monster.length; i++) {
                if (monster[i] != null) {
                    monster[i].update();
                    // Add the updated monster to the list
                    entityList.add(monster[i]);
                }
            }

            // Check collisions between entities of the same type
            for (Entity entity1 : entityList) {
                for (Entity entity2 : entityList) {
                    if (entity1 != entity2) {
                        cChecker.checkEntity(entity1, new Entity[] { entity2 });
                    }
                }
            }
        }
        if (gameState == pauseState) {
            // nothing
        }
    }

    // Draws components on the panel
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        long drawStart = 0;
        if (keyH.renderTime == true) {
            drawStart = System.nanoTime();
        }

        if (gameState == titleState) {
            ui.draw(g2);
        }

        else {

            tileM.draw(g2);

            // Sort for render order i.e. proper entity overlap
            Collections.sort(entityList, new Comparator<Entity>() {

                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }

            });

            // drawing all entities
            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }

            ui.draw(g2);

            if (keyH.renderTime == true) {
                long drawEnd = System.nanoTime();
                long timeToRender = drawEnd - drawStart;
                g2.setColor(Color.WHITE);
                g2.drawString("Draw Time: " + timeToRender, 10, 400);
                System.out.println("Draw Time: " + timeToRender);

            }

            g2.dispose();
        }
    }

    // Plays the music
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    // Stops the music
    public void stopMusic() {
        music.stop();
    }

    // Plays the sound effects
    public void playSFX(int i) {
        sfx.setFile(i);
        sfx.play();
    }
}

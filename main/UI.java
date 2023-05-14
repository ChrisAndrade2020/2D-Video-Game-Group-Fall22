package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
// import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font fontserrat;

    public boolean messageOn = false;
    public String message = "";

    int messageCounter = 0;

    public boolean gameFinish = false;

    public UI(GamePanel gp) {

        this.gp = gp;
        fontserrat = new Font("Montserrat", Font.BOLD, gp.tileSize / 4);

    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(fontserrat);
        g2.setColor(Color.WHITE);

        if (gp.gameState == gp.playState) {

        }

        if (gp.gameState == gp.pauseState) {

            drawPauseScreen();

        }

    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));

        String text = "PAUSED";

        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public int getXforCenteredText(String text) {

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        int x = gp.screenWidth / 2 - length / 2;

        return x;

    }
}

package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.InputStream;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font Montserrat, MontserratBold;

    // tileSize = 48

    public boolean messageOn = false;
    public String message = "";

    int messageCounter = 0;

    public boolean gameFinish = false;

    public String currentDialogue = "";

    public UI(GamePanel gp) {

        this.gp = gp;

        try {
            InputStream is = getClass().getResourceAsStream("/res/font/Montserrat-Regular.ttf");
            Montserrat = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/res/font/Montserrat-Bold.ttf");
            MontserratBold = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
            ;

        }

    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(Montserrat);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);

        if (gp.gameState == gp.playState) {

        }

        if (gp.gameState == gp.pauseState) {

            drawPauseScreen();

        }

        if (gp.gameState == gp.dialogueState) {

            drawdialogueScreen();

        }

    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));

        String text = "PAUSED";

        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public void drawdialogueScreen() {

        int x = gp.tileSize / 2;
        double y = gp.tileSize * 7.5;
        int width = gp.screenWidth - (gp.tileSize * 8);
        int height = gp.tileSize * 2;

        drawTextWindow(x, (int) y, width, height);

    }

    public void drawTextWindow(int x, int y, int width, int height) {

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, gp.tileSize / 4));

        Color c = new Color(0, 0, 0, 190);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x + 2, y + 2, width - 4, height - 4, 31, 31);

        x += gp.tileSize / 2;
        y += gp.tileSize / 2;

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += gp.tileSize / 2;
        }

    }

    public int getXforCenteredText(String text) {

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        int x = gp.screenWidth / 2 - length / 2;

        return x;

    }
}

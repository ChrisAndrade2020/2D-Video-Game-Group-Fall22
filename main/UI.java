package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import object.ObjectHeart;
import object.SuperObject;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font Montserrat, MontserratBold;

    BufferedImage heart, heart_border, heart_empty;

    public boolean messageOn = false;
    public String message = "";

    int messageCounter = 0;

    public boolean gameFinish = false;

    public String currentDialogue = "";

    public int commandNum = 0;

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

        }

        SuperObject heart = new ObjectHeart(gp);
        heart = heart.image1;
        heart_border = heart.image2;
        heart_empty = heart.image3;

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

        if (gp.gameState == gp.titleState) {

            drawTitleScreen();

        }

        if (gp.gameState == gp.playState) {

        }

        if (gp.gameState == gp.pauseState) {

            drawPauseScreen();

        }

        if (gp.gameState == gp.dialogueState) {

            drawdialogueScreen();

        }

    }

    private void drawTitleScreen() {

        g2.setColor(new Color(77, 138, 179));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, gp.tileSize * 2));
        String text = "Mystic Isles";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 3;

        g2.setColor(Color.BLACK);
        g2.drawString(text, x + 3, y + 3);

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, gp.tileSize));
        text = "New Game";
        x = getXforCenteredText(text);
        y += gp.tileSize * 3;
        g2.setColor(Color.BLACK);
        g2.drawString(text, x + 3, y + 3);

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Load Game";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.setColor(Color.BLACK);
        g2.drawString(text, x + 3, y + 3);

        g2.setColor(Color.GRAY);
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Quit";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.setColor(Color.BLACK);
        g2.drawString(text, x + 3, y + 3);

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        if (commandNum == 2) {
            g2.drawString(">", x - gp.tileSize, y);
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

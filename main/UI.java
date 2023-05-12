package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.ObjectKeyGold;
import object.ObjectKeyIron;

public class UI {

    GamePanel gp;
    Font fontserrat;
    BufferedImage goldKeyImage;
    BufferedImage ironKeyImage;

    public boolean messageOn = false;
    public String message = "";

    int messageCounter = 0;

    public UI(GamePanel gp) {

        this.gp = gp;
        fontserrat = new Font("Montserrat", Font.BOLD, gp.tileSize / 4);
        ObjectKeyGold key_gold = new ObjectKeyGold();
        ObjectKeyIron key_iron = new ObjectKeyIron();
        goldKeyImage = key_gold.image;
        ironKeyImage = key_iron.image;

    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {

        g2.setFont(fontserrat);
        g2.setColor(Color.WHITE);

        g2.drawImage(goldKeyImage, gp.tileSize / 4, gp.tileSize / 4, gp.tileSize / 2, gp.tileSize / 2, null);
        g2.drawImage(ironKeyImage, 36, gp.tileSize / 4, gp.tileSize / 2, gp.tileSize / 2, null);

        g2.drawString("" + gp.player.hasGoldKey, 30, gp.tileSize - 12);
        g2.drawString("" + gp.player.hasIronKey, 54, gp.tileSize - 12);

        // Messages
        if (messageOn == true) {

            g2.setFont(g2.getFont().deriveFont(gp.tileSize));
            g2.drawString(message, gp.tileSize / 2, gp.tileSize + 4);

            messageCounter++;

            if (messageCounter > 120) {

                // messages disappear after 120 fames , i.e 2 seconds.
                messageCounter = 0;
                messageOn = false;

            }

        }

    }

}
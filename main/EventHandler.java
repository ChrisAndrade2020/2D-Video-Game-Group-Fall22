package main;

import java.awt.Rectangle;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    boolean inpatchyGrassEvent = false;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;

        eventRect.width = 2;
        eventRect.height = 2;

        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

    }

    public void checkEvent() {

        if (hit(20, 85, "down")) {
            if (!inpatchyGrassEvent) {
                inpatchyGrassEvent = true;
                patchyGrass(gp.dialogueState);
            }
        } else {
            inpatchyGrassEvent = false;
        }
        if (hit(24, 93, "idle")) {
            healingTile(gp.dialogueState);
        }
        if (hit(9, 86, "up")) {
            teleportSomewhere(gp.dialogueState);
        }

    }

    private void healingTile(int gameState) {
        if (gp.keyH.enter == true) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "You feel better...";
            gp.player.health = gp.player.maxHealth;
        }
    }

    private void patchyGrass(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You tripped!";
        gp.player.health -= 1;
    }

    private void teleportSomewhere(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "What's going on?!";
        gp.player.worldX = gp.tileSize * 77;
        gp.player.worldY = gp.tileSize * 3;
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection) {
        boolean hit = false;

        Rectangle tempPlayerArea = new Rectangle(gp.player.solidArea);
        tempPlayerArea.x += gp.player.worldX;
        tempPlayerArea.y += gp.player.worldY;

        Rectangle tempEventRect = new Rectangle(eventRect);
        tempEventRect.x += eventCol * gp.tileSize;
        tempEventRect.y += eventRow * gp.tileSize;

        if (tempPlayerArea.intersects(tempEventRect)) {
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;
            }
        }

        return hit;
    }
}

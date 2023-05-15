package main;

public class EventHandler {

    GamePanel gp;
    EventRect eventRect[][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) { // Change maxScreenRow to maxWorldRow

            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;

            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }

    public void checkEvent() {

        // Check player entity distance from event tile
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if (distance > gp.tileSize * 2) {
            canTouchEvent = true; // when player is 2 tiles away from previously triggered tile.
        }

        if (canTouchEvent == true) {

            if (hit(20, 85, "down")) {
                patchyGrass(20, 85, gp.dialogueState);
            }
            if (hit(24, 93, "idle")) {
                healingTile(24, 93, gp.dialogueState);
            }
            if (hit(9, 86, "up")) {
                teleportSomewhere(9, 86, gp.dialogueState);
            }
        }

    }

    private void teleportSomewhere(int col, int row, int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "Something feels weird...";
        gp.player.worldX = gp.tileSize * 77;
        gp.player.worldY = gp.tileSize * 2;
    }

    private void healingTile(int col, int row, int gameState) {
        if (gp.keyH.enter == true) {
            gp.gameState = gameState;
            gp.ui.currentDialogue = "You feel better...";
            gp.player.health = gp.player.maxHealth;
        }
    }

    private void patchyGrass(int col, int row, int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You tripped!";
        gp.player.health -= 1;
        // eventRect[col][row].eventDone = true;
        canTouchEvent = false;
    }

    public boolean hit(int col, int row, String reqDirection) {

        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

        if (gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;
                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;

        return hit;
    }
}

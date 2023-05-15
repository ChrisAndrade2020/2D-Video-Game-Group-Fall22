package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean up, down, left, right, enter;
    boolean renderTime;
    GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

        // Unused

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // playstate
        if (gp.gameState == gp.playState) {

            if (code == KeyEvent.VK_W) {
                up = true;
            }

            if (code == KeyEvent.VK_S) {
                down = true;
            }

            if (code == KeyEvent.VK_A) {
                left = true;
            }

            if (code == KeyEvent.VK_D) {
                right = true;
            }

            if (code == KeyEvent.VK_CAPS_LOCK) { // makes TAB toggleable to check render performance.

                if (renderTime == false) {

                    renderTime = true;

                }

                else if (renderTime == true) {

                    renderTime = false;

                }

            }

            if (code == KeyEvent.VK_P) {

                gp.gameState = gp.pauseState;

            }

            if (code == KeyEvent.VK_ENTER) {

                enter = true;

            }

        }

        // pauseState
        else if (gp.gameState == gp.pauseState) {

            if (code == KeyEvent.VK_P) {

                gp.gameState = gp.playState;

            }

        }

        // dialogueState
        else if (gp.gameState == gp.dialogueState) {

            if (code == KeyEvent.VK_ENTER) {

                gp.gameState = gp.playState;

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            up = false;

        }

        if (code == KeyEvent.VK_S) {

            down = false;

        }

        if (code == KeyEvent.VK_A) {

            left = false;

        }

        if (code == KeyEvent.VK_D) {

            right = false;

        }

    }

}

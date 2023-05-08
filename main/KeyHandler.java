package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean up, down, left, right;
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

        // if (code == KeyEvent.VK_PAGE_UP) {
        // gp.zoomScreen(1);
        // }

        // if (code == KeyEvent.VK_PAGE_DOWN) {
        // gp.zoomScreen(-1);

        // }

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

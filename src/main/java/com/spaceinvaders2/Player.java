package com.spaceinvaders2;
 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y;
    private int dx;
    private int playerNumber; // 1 or 2
    private int lives;

    public Player(int x, int y, int playerNumber) {
        this.x = x;
        this.y = y;
        this.playerNumber = playerNumber;
        this.lives = 3; // Start with 3 lives for each player
    }

    public void update() {
        x += dx;
        if (x < 0) {
            x = 0;
        }
        if (x > 750) {
            x = 750;
        }
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, 50, 20);
        // Optionally: Draw different colors or shapes for different players
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (playerNumber == 1) {
            if (key == KeyEvent.VK_LEFT) {
                dx = -3;
            } else if (key == KeyEvent.VK_RIGHT) {
                dx = 3;
            } else if (key == KeyEvent.VK_SHIFT) {
                // Player 1 shoot
            }
        } else if (playerNumber == 2) {
            if (key == KeyEvent.VK_A) {
                dx = -3;
            } else if (key == KeyEvent.VK_D) {
                dx = 3;
            } else if (key == KeyEvent.VK_SPACE) {
                // Player 2 shoot
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (playerNumber == 1) {
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
                dx = 0;
            }
        } else if (playerNumber == 2) {
            if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
                dx = 0;
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 20);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }
}

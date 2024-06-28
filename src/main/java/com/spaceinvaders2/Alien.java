package com.spaceinvaders2;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Alien {
    private int x, y;
    private int speed;
    private boolean movingRight;

    public Alien(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.movingRight = true;
    }

    public void update() {
        try {
            if (movingRight) {
                x += speed;
                if (x > 750) {
                    movingRight = false;
                    y += 20; // Move down when hitting the edge
                }
            } else {
                x -= speed;
                if (x < 0) {
                    movingRight = true;
                    y += 20; // Move down when hitting the edge
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        try {
            g.fillRect(x, y, 40, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Rectangle getBounds() {
        try {
            return new Rectangle(x, y, 40, 20);
        } catch (Exception e) {
            e.printStackTrace();
            return new Rectangle(); // Return an empty rectangle in case of error
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
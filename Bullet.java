package com.spaceinvaders2;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
    private int x, y;
    private int speed;
    private boolean isAlienBullet;

    public Bullet(int x, int y) {
        this(x, y, 7);
        this.isAlienBullet = false;
    }

    public Bullet(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.isAlienBullet = true;
    }

    public void update() {
        try {
            if (isAlienBullet) {
                y += speed;
            } else {
                y -= speed;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        try {
            g.fillRect(x, y, 5, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        try {
            return new Rectangle(x, y, 5, 10);
        } catch (Exception e) {
            e.printStackTrace();
            return new Rectangle(); // Return an empty rectangle in case of error
        }
    }
}
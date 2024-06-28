package com.spaceinvaders2;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener {
    private Thread thread;  
    private boolean running;
    private Player player1; // Player 1
    private Player player2; // Player 2
    private List<Alien> aliens;
    private List<Bullet> bullets;
    private List<Bullet> alienBullets;
    private Difficulty difficulty;
    private GameState state;
    private long lastShotTime;
    private Random random;
    private int currLevel = 1;

    public enum GameState {
        START,
        RUNNING,
        GAME_OVER
    }

    public SpaceInvaders() {
        try {
            setFocusable(true);
            addKeyListener(this);
            player1 = new Player(375, 550, 1);
            player2 = new Player(425, 550, 2);
            aliens = new ArrayList<>();
            bullets = new ArrayList<>();
            alienBullets = new ArrayList<>();
            difficulty = Difficulty.EASY; // Start at easy difficulty
            state = GameState.START;
            lastShotTime = 0;
            random = new Random();
            initializeAliens();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            thread = new Thread(this);
            running = true;
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeAliens() {
        try {
            int rows = 5;
            int cols = 10;
            int alienSpeed = difficulty.getAlienSpeed();
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    aliens.add(new Alien(50 + col * 50, 50 + row * 50, alienSpeed));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (running) {
            try {
                if (state == GameState.RUNNING) {
                    update();
                }
                repaint();
                Thread.sleep(17); // Approximately 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        try {
            player1.update();
            player2.update();
            for (Bullet bullet : bullets) {
                bullet.update();
            }
            for (Bullet bullet : alienBullets) {
                bullet.update();
            }
            for (Alien alien : aliens) {
                alien.update();
            }
            checkCollisions();
            removeOffScreenBullets();
            checkGameOver();
            if (aliens.isEmpty()) {
                difficulty.increaseDifficulty(); // Increase difficulty
                initializeAliens(); // Reinitialize aliens
                // Next level
                currLevel++;                
            }
            checkAlienShooting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkCollisions() {
        try {
            List<Bullet> bulletsToRemove = new ArrayList<>();
            List<Bullet> alienBulletsToRemove = new ArrayList<>();
            List<Alien> aliensToRemove = new ArrayList<>();

            for (Bullet bullet : bullets) {
                for (Alien alien : aliens) {
                    if (bullet.getBounds().intersects(alien.getBounds())) {
                        bulletsToRemove.add(bullet);
                        aliensToRemove.add(alien);
                    }
                }
            }

            for (Bullet bullet : alienBullets) {
                if (bullet.getBounds().intersects(player1.getBounds())) {
                    alienBulletsToRemove.add(bullet);
                    player1.loseLife();
                    if (player1.getLives() <= 0) {
                        state = GameState.GAME_OVER;
                    }
                }
                if (bullet.getBounds().intersects(player2.getBounds())) {
                    alienBulletsToRemove.add(bullet);
                    player2.loseLife();
                    if (player2.getLives() <= 0) {
                        state = GameState.GAME_OVER;
                    }
                }
            }

            bullets.removeAll(bulletsToRemove);
            alienBullets.removeAll(alienBulletsToRemove);
            aliens.removeAll(aliensToRemove);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeOffScreenBullets() {
        try {
            bullets.removeIf(bullet -> bullet.getY() < 0);
            alienBullets.removeIf(bullet -> bullet.getY() > getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkGameOver() {
        try {
            for (Alien alien : aliens) {
                if (alien.getBounds().intersects(player1.getBounds()) || alien.getBounds().intersects(player2.getBounds()) || alien.getY() >= getHeight() - 20) {
                    state = GameState.GAME_OVER;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void chooseAliensToShoot() {
        try {
            int shooters = difficulty.getAlienShooters();
            for (int i = 0; i < shooters; i++) {
                if (!aliens.isEmpty()) {
                    int index = random.nextInt(aliens.size());
                    Alien shooter = aliens.get(index);
                    alienBullets.add(new Bullet(shooter.getX() + 20, shooter.getY() + 20, 5)); // Add alien bullet
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkAlienShooting() {
        try {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastShotTime >= 2000) { // 0.8 seconds delay
                chooseAliensToShoot();
                lastShotTime = currentTime;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            if (state == GameState.START) {
                drawStartScreen(g);
            } else if (state == GameState.RUNNING) {
                player1.draw(g);
                player2.draw(g);
                for (Bullet bullet : bullets) {
                    bullet.draw(g);
                }
                for (Bullet bullet : alienBullets) {
                    bullet.draw(g);
                }
                for (Alien alien : aliens) {
                    alien.draw(g);
                }
                drawLives(g);
                drawLevel(g);
            } else if (state == GameState.GAME_OVER) {
                drawGameOverScreen(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawStartScreen(Graphics g) {
        try {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 36));
            g.drawString("Space Invaders", 270, 200);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Player 1: press A and D to move side to side. Shoot with SPACE", 90, 300);
            g.drawString("Player 2: press <- and -> to move side to side. Shoot with SHIFT", 90, 350);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Press ENTER to Start", 290, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawGameOverScreen(Graphics g) {
        try {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 36));
            g.drawString("Game Over", 300, 300);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Press ENTER to Restart", 270, 350);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawLives(Graphics g) {
        try {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("P1 Lives: " + player1.getLives(), 10, 30);
            g.drawString("P2 Lives: " + player2.getLives(), 600, 30);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void drawLevel(Graphics g) {
        try {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Level: " + currLevel, 330, 30);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // KeyListener methods
    public void keyPressed(KeyEvent e) {
        try {
            if (state == GameState.START || state == GameState.GAME_OVER) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    startNewGame();
                }
            } else if (state == GameState.RUNNING) {
                player1.keyPressed(e);
                player2.keyPressed(e);
                // Implement bullet creation logic here based on the keys
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    // Player 1 shoot
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastShotTime >= 200) { // 0.5 seconds delay
                        bullets.add(new Bullet(player1.getX() + 22, player1.getY()));
                        lastShotTime = currentTime;
                    }   
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    // Player 2 shoot
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastShotTime >= 200) { // 0.5 seconds delay
                        bullets.add(new Bullet(player2.getX() + 22, player2.getY())); // Adjust bullet position
                        lastShotTime = currentTime;
                    }                   
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void keyReleased(KeyEvent e) {
        try {
            if (state == GameState.RUNNING) {
                player1.keyReleased(e);
                player2.keyReleased(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void keyTyped(KeyEvent e) {}

    private void startNewGame() {
        try {
            player1 = new Player(375, 550, 1);
            player2 = new Player(425, 550, 2);
            aliens = new ArrayList<>();
            bullets = new ArrayList<>();
            alienBullets = new ArrayList<>();
            difficulty = Difficulty.EASY; // Reset difficulty to easy
            initializeAliens();
            state = GameState.RUNNING;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

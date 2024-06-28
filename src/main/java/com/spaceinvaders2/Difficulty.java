package com.spaceinvaders2;

public enum Difficulty {
    EASY(1, 1),
    MEDIUM(2, 2),
    HARD(3, 3);

    private int alienSpeed;
    private int alienShooters;

    Difficulty(int alienSpeed, int alienShooters) {
        this.alienSpeed = alienSpeed;
        this.alienShooters = alienShooters;
    }

    public int getAlienSpeed() {
        try {
            return alienSpeed;
        } catch (Exception e) {
            e.printStackTrace();
            return 1; // Default value
        }
    }

    public int getAlienShooters() {
        try {
            return alienShooters;
        } catch (Exception e) {
            e.printStackTrace();
            return 1; // Default value
        }
    }

    public void increaseDifficulty() {
        try {
            alienSpeed++;
            alienShooters++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

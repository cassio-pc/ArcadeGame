package com.spaceinvaders2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceInvaders2 {
    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("Space Invaders");
            SpaceInvaders game = new SpaceInvaders();
            frame.add(game);
            frame.setSize(800, 680);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            JButton exitButton = new JButton("Exit");
            exitButton.addActionListener((ActionEvent e) -> {
                System.exit(0);
            });

            // Create a panel for the buttons and add it to the bottom of the frame
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(exitButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
            game.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

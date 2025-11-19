package com.example.snake;


import javax.swing.*;
import java.awt.*;


public class Main {
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
JFrame frame = new JFrame("Snake — Simple Java Game");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);


GamePanel panel = new GamePanel();
frame.add(panel);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);


panel.startGame();
});
}
}

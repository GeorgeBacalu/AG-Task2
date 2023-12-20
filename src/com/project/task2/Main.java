package com.project.task2;

import com.project.task2.component.AppPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Labyrinth");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new AppPanel());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

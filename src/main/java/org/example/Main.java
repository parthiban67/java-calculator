package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            JFrame frame = new JFrame("Calculator");
            frame.setSize(350,500);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        };
        SwingUtilities.invokeLater(runnable);
    }
}
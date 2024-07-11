package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            new Application().start();
        };
        SwingUtilities.invokeLater(runnable);
    }
}
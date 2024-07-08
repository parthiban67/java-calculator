package org.example;

import org.example.menu.MenuBar;
import org.example.themes.Theme;
import org.example.themes.ThemeFactory;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            JFrame frame = new JFrame("Calculator");
            frame.setSize(350,500);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Theme theme = ThemeFactory.getTheme(ThemeFactory.Type.PLATFORM);
            MenuBar menuBar = new MenuBar(theme,e->{
                frame.dispose();
            });

            LayoutManager borderLayout = new BorderLayout();
            frame.setLayout(borderLayout);

            frame.add(menuBar.getMenuBar(),BorderLayout.NORTH);

            JPanel panel = new JPanel();
            frame.add(panel,BorderLayout.CENTER);
        };
        SwingUtilities.invokeLater(runnable);
    }
}
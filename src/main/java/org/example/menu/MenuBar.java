package org.example.menu;

import org.example.themes.Theme;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class MenuBar {

    private final JMenuBar menuBar;
    private Theme currentTheme;
    private final Consumer<MouseEvent> exitHandler;

    public MenuBar(Theme theme, Consumer<MouseEvent> exitHandler){
        menuBar = new JMenuBar();
        currentTheme = theme;
        this.exitHandler = exitHandler;
        setupMenuTheme();
        setupMenus();
    }

    public void setCurrentTheme(Theme currentTheme) {
        this.currentTheme = currentTheme;
    }

    private void setupMenuTheme(){
        menuBar.setBackground(currentTheme.getMenuBarBackground());
        menuBar.setForeground(currentTheme.getMenuBarForeground());
    }

    private void setupMenus(){
        addModeMenu();
        addAboutMenu();
        addExitMenu();
    }

    private void addModeMenu(){
        JMenu modeMenu = new JMenu("Mode");
        JMenuItem standard = new JMenuItem("Standard");
        modeMenu.add(standard);

        menuBar.add(modeMenu);
    }

    private void addAboutMenu(){
        JMenu aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);
        aboutMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(menuBar.getParent(),"Simple Calculator rewritten in swing after 7 years");
            }
        });
    }

    private void addExitMenu(){
        JMenu exitMenu = new JMenu("Exit");
        menuBar.add(exitMenu);
        exitMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exitHandler.accept(e);
            }
        });
    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }
}

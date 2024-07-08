package org.example.menu;

import org.example.themes.Theme;

import javax.swing.*;

public class MenuBar {

    private final JMenuBar menuBar;
    private Theme currentTheme;

    public MenuBar(Theme theme){
        menuBar = new JMenuBar();
        currentTheme = theme;

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

    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }
}

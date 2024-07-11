package org.example.controller;

import org.example.themes.Theme;
import org.example.view.Display;

import javax.swing.*;
import java.awt.*;

public class Controller {

    private final Display display;
    private Theme currentTheme;
    private final JPanel panel;

    public Controller(Display display, Theme currentTheme) {
        this.display = display;
        this.currentTheme = currentTheme;
        this.panel = new JPanel();
    }

    public void setCurrentTheme(Theme currentTheme) {
        this.currentTheme = currentTheme;
    }

    public JPanel getController(){
        panel.setBackground(Color.BLUE);
        return panel;
    }
}

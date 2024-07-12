package org.example.view;

import org.example.themes.Theme;

import javax.swing.*;
import java.awt.*;

public class Display {

    private final JPanel panel;
    private final JLabel label;
    private Theme currentTheme;

    public Display(Theme currentTheme) {
        this.panel = new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10));
        label = new JLabel("0");
        this.currentTheme = currentTheme;
        setupLabel();
    }

    public void setCurrentTheme(Theme currentTheme) {
        this.currentTheme = currentTheme;
    }

    public JPanel getDisplay(){
        return panel;
    }

    private void setupLabel(){
        this.panel.setBackground(Color.WHITE);
        Font font = this.label.getFont();
        this.label.setFont(new Font(font.getFontName(),font.getStyle(),22));
        this.label.setForeground(Color.GRAY);
        this.panel.add(this.label);
    }

    public void updateLabelValue(String value){
        this.label.setText(value);
    }
}

package org.example.view;

import org.example.themes.Theme;

import javax.swing.*;
import java.awt.*;

public class Display {

    private final JPanel panel;
    private Theme currentTheme;

    public Display(Theme currentTheme) {
        this.panel = new JPanel(new FlowLayout(FlowLayout.TRAILING,10,10));
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
        JLabel label = new JLabel("0");
        Dimension dimension = label.getPreferredSize();
        Font font = label.getFont();
        label.setFont(new Font(font.getFontName(),font.getStyle(),22));
        //label.setPreferredSize(new Dimension(dimension.width-100,50));
        label.setForeground(Color.BLUE);
        panel.add(label);
    }
}

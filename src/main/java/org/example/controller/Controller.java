package org.example.controller;

import org.example.themes.Theme;
import org.example.view.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class Controller {

    private final Display display;
    private Theme currentTheme;
    private final JPanel panel;
    private final StringBuilder buffer;

    public Controller(Display display, Theme currentTheme) {
        this.display = display;
        this.currentTheme = currentTheme;
        this.panel = new JPanel(new GridBagLayout());
        this.buffer = new StringBuilder();
        this.setupButtons();
    }

    public void setCurrentTheme(Theme currentTheme) {
        this.currentTheme = currentTheme;
    }

    public void emitLabelToDisplay(ActionEvent e){
        this.buffer.append(e.getActionCommand());
        this.display.updateLabelValue(buffer.toString());
    }

    private void setupButtons(){
        this.addButton("(",0,0,1,1,this::emitLabelToDisplay);
        this.addButton(")",1,0,1,1,this::emitLabelToDisplay);
        this.addButton("DEL",2,0,1,1,this::emitLabelToDisplay);
        this.addButton("CLS",3,0,1,1,this::emitLabelToDisplay);
        this.addButton("+",0,1,1,1,this::emitLabelToDisplay);
        this.addButton("7",1,1,1,1,this::emitLabelToDisplay);
        this.addButton("8",2,1,1,1,this::emitLabelToDisplay);
        this.addButton("9",3,1,1,1,this::emitLabelToDisplay);
        this.addButton("-",0,2,1,1,this::emitLabelToDisplay);
        this.addButton("4",1,2,1,1,this::emitLabelToDisplay);
        this.addButton("5",2,2,1,1,this::emitLabelToDisplay);
        this.addButton("6",3,2,1,1,this::emitLabelToDisplay);
        this.addButton("*",0,3,1,1,this::emitLabelToDisplay);
        this.addButton("1",1,3,1,1,this::emitLabelToDisplay);
        this.addButton("2",2,3,1,1,this::emitLabelToDisplay);
        this.addButton("3",3,3,1,1,this::emitLabelToDisplay);
        this.addButton("/",0,4,1,1,this::emitLabelToDisplay);
        this.addButton("0",1,4,1,1,this::emitLabelToDisplay);
        this.addButton("=",2,4,2,1,this::emitLabelToDisplay);
    }

    private void addButton(final String label, final int x, final int y, final int w, final int h, Consumer<ActionEvent> buttonHandler){
        JButton button = new JButton(label);
        button.setBackground(Color.lightGray);
        Font font = button.getFont();
        button.setFont(new Font(font.getFontName(),font.getStyle(),14));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.addActionListener(buttonHandler::accept);
        Insets insets = new Insets(0,0,0,0);
        this.panel.add(button,new GridBagConstraints(x,y,w,h,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0));
    }

    public JPanel getController(){
        return this.panel;
    }
}

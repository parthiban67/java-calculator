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

    private void appendBuffer(ActionEvent e){
        this.buffer.append(e.getActionCommand());
        this.display.updateLabelValue(buffer.toString());
    }

    private void clearBuffer(ActionEvent e){
        this.buffer.setLength(0);
        this.display.updateLabelValue("0");
    }

    private void lastCharDeleteBuffer(ActionEvent e){
        if(this.buffer.length() <= 1){
            this.buffer.setLength(0);
            this.display.updateLabelValue("0");
        }else{
            this.buffer.deleteCharAt(this.buffer.length()-1);
            this.display.updateLabelValue(buffer.toString());
        }
    }

    private void performCalculation(ActionEvent e){
        this.buffer.setLength(0);
        this.display.updateLabelValue("0");
    }

    private void setupButtons(){
        this.addButton("(",0,0,1,1,this::appendBuffer);
        this.addButton(")",1,0,1,1,this::appendBuffer);
        this.addButton("DEL",2,0,1,1,this::lastCharDeleteBuffer);
        this.addButton("CLS",3,0,1,1,this::clearBuffer);
        this.addButton("+",0,1,1,1,this::appendBuffer);
        this.addButton("7",1,1,1,1,this::appendBuffer);
        this.addButton("8",2,1,1,1,this::appendBuffer);
        this.addButton("9",3,1,1,1,this::appendBuffer);
        this.addButton("-",0,2,1,1,this::appendBuffer);
        this.addButton("4",1,2,1,1,this::appendBuffer);
        this.addButton("5",2,2,1,1,this::appendBuffer);
        this.addButton("6",3,2,1,1,this::appendBuffer);
        this.addButton("*",0,3,1,1,this::appendBuffer);
        this.addButton("1",1,3,1,1,this::appendBuffer);
        this.addButton("2",2,3,1,1,this::appendBuffer);
        this.addButton("3",3,3,1,1,this::appendBuffer);
        this.addButton("/",0,4,1,1,this::appendBuffer);
        this.addButton("0",1,4,1,1,this::appendBuffer);
        this.addButton("=",2,4,2,1,this::performCalculation);
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

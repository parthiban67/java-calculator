package org.example;

import org.example.controller.Controller;
import org.example.menu.MenuBar;
import org.example.themes.Theme;
import org.example.themes.ThemeFactory;
import org.example.view.Display;

import javax.swing.*;
import java.awt.*;

public class Application {

    private JFrame frame;
    private Theme theme;

    private void init(){
        theme = ThemeFactory.getTheme(ThemeFactory.Type.PLATFORM);
    }

    private void initFrame(){
        frame = new JFrame("Calculator");
        frame.setSize(350,500);
        frame.setVisible(true);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initMenuBar(){
        MenuBar menuBar = new MenuBar(theme, e->{
            frame.dispose();
        });
        frame.setJMenuBar(menuBar.getMenuBar());
    }

    private void initMainPanel(){
        GridBagLayout gridBagLayout = new GridBagLayout();
        JPanel panel = new JPanel(gridBagLayout);
        Display display = new Display(theme);
        Controller controller = new Controller(display,theme);
        Insets insets = new Insets(0,0,0,0);
        panel.add(display.getDisplay(),new GridBagConstraints(0,0,1,0,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,insets,0,0));
        panel.add(controller.getController(),new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,insets,0,0));
        frame.add(panel);
    }

    public void start(){
        this.init();
        this.initFrame();
        this.initMenuBar();
        this.initMainPanel();
    }
}

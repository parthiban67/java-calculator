package org.example.themes;

import javax.swing.*;
import java.awt.*;

public class PlatformTheme implements Theme{

    private final UIDefaults uiDefaults;

    public PlatformTheme(){
        uiDefaults = UIManager.getLookAndFeel().getDefaults();
    }

    @Override
    public Color getMenuBarBackground() {
        return (Color) uiDefaults.get("MenuBar.background");
    }

    @Override
    public Color getMenuBarForeground() {
        return (Color) uiDefaults.get("MenuBar.foreground");
    }
}

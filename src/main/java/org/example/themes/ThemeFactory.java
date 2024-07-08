package org.example.themes;

public class ThemeFactory {

    public enum Type{
        PLATFORM
    }

    public static Theme getTheme(Type type){
        return switch (type){
            case PLATFORM -> new PlatformTheme();
        };
    }
}

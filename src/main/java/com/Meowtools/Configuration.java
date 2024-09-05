package com.Meowtools;

public class Configuration {
    public final String lookUpSwapCommand;
    public final boolean lookUpSwapAsConsole;
    public final String lookDownSwapCommand;
    public final boolean lookDownSwapAsConsole;
    public final String lookUpDropCommand;
    public final boolean lookUpDropAsConsole;
    public final String lookDownDropCommand;
    public final boolean lookDownDropAsConsole;
    public final String sneakSwapCommand;
    public final boolean sneakSwapAsConsole;
    public final String sneakDropCommand;
    public final boolean sneakDropAsConsole;
    public final boolean debug;

    public Configuration(String lookUpSwapCommand, boolean lookUpSwapAsConsole,
                         String lookDownSwapCommand, boolean lookDownSwapAsConsole,
                         String lookUpDropCommand, boolean lookUpDropAsConsole,
                         String lookDownDropCommand, boolean lookDownDropAsConsole,
                         String sneakSwapCommand, boolean sneakSwapAsConsole,
                         String sneakDropCommand, boolean sneakDropAsConsole,
                         boolean debug
    ) {
        this.lookUpSwapCommand = lookUpSwapCommand;
        this.lookUpSwapAsConsole = lookUpSwapAsConsole;
        this.lookDownSwapCommand = lookDownSwapCommand;
        this.lookDownSwapAsConsole = lookDownSwapAsConsole;
        this.lookUpDropCommand = lookUpDropCommand;
        this.lookUpDropAsConsole = lookUpDropAsConsole;
        this.lookDownDropCommand = lookDownDropCommand;
        this.lookDownDropAsConsole = lookDownDropAsConsole;
        this.sneakSwapCommand = sneakSwapCommand;
        this.sneakSwapAsConsole = sneakSwapAsConsole;
        this.sneakDropCommand = sneakDropCommand;
        this.sneakDropAsConsole = sneakDropAsConsole;
        this.debug = debug;
    }
}

package com.Meowtools;

public class Configuration {
    public final String lookUpCommand;
    public final boolean lookUpAsConsole;
    public final String lookDownCommand;
    public final boolean lookDownAsConsole;
    public final String lookUpDropCommand;
    public final boolean lookUpDropAsConsole;
    public final String lookDownDropCommand;
    public final boolean lookDownDropAsConsole;
    public final String sneakSwapCommand;
    public final boolean sneakSwapAsConsole;
    public final String sneakDropCommand;
    public final boolean sneakDropAsConsole;
    public final boolean debug;

    public Configuration(String lookUpCommand, boolean lookUpAsConsole,
                         String lookDownCommand, boolean lookDownAsConsole,
                         String lookUpDropCommand, boolean lookUpDropAsConsole,
                         String lookDownDropCommand, boolean lookDownDropAsConsole,
                         String sneakSwapCommand, boolean sneakSwapAsConsole,
                         String sneakDropCommand, boolean sneakDropAsConsole,
                         boolean debug
    ) {
        this.lookUpCommand = lookUpCommand;
        this.lookUpAsConsole = lookUpAsConsole;
        this.lookDownCommand = lookDownCommand;
        this.lookDownAsConsole = lookDownAsConsole;
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

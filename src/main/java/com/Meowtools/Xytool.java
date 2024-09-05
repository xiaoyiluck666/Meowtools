package com.Meowtools;

import org.bukkit.plugin.java.JavaPlugin;

public class Xytool extends JavaPlugin {

    private Configuration config;
    private static final String CONFIG_VERSION = "1.0"; // 新增配置版本号常量

    @Override
    public void onEnable() {
        loadConfig();
        registerEventsAndCommands();
        getLogger().info("Meowtools插件已启用!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Meowtools插件已禁用!");
    }

    private void registerEventsAndCommands() {
        // 注册事件监听器和命令执行器
        getServer().getPluginManager().registerEvents(new PlayerActionListener(this), this);
        getCommand("xytool").setExecutor(new MeowtoolsCommand(this));
        getServer().getPluginManager().registerEvents(new MeowControl(this), this);
    }

    private void checkAndUpdateConfig() {
        saveDefaultConfig();
        String currentVersion = getConfig().getString("configVersion", "");

        if (!currentVersion.equals(CONFIG_VERSION)) {
            getLogger().info("更新配置文件到版本 " + CONFIG_VERSION);
            getConfig().options().copyDefaults(true); // 更新到默认配置
            getConfig().set("configVersion", CONFIG_VERSION);
            saveConfig();
            reloadConfig();
        }
    }
    public void loadConfig() {
        saveDefaultConfig();
        reloadConfig();
        this.config = new Configuration(
                getConfig().getString("lookUpCommand.command", ""),
                getConfig().getBoolean("lookUpCommand.asConsole", false),
                getConfig().getString("lookDownCommand.command", ""),
                getConfig().getBoolean("lookDownCommand.asConsole", false),
                getConfig().getString("lookUpDropCommand.command", ""),
                getConfig().getBoolean("lookUpDropCommand.asConsole", false),
                getConfig().getString("lookDownDropCommand.command", ""),
                getConfig().getBoolean("lookDownDropCommand.asConsole", false),
                getConfig().getString("sneakSwapCommand.command", ""),
                getConfig().getBoolean("sneakSwapCommand.asConsole", false),
                getConfig().getString("sneakDropCommand.command", ""),
                getConfig().getBoolean("sneakDropCommand.asConsole", false),
                getConfig().getBoolean("debug", true)
        );
    }

    public Configuration getConfiguration() {
        return config;
    }
}

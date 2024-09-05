package com.Meowtools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MeowtoolsCommand implements CommandExecutor {

    private final Xytool plugin;

    public MeowtoolsCommand(Xytool plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("xytool") && args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("meowtools.reload")) {
                plugin.reloadConfig(); // 确保配置重新加载
                plugin.loadConfig();   // 更新内存中的配置对象
                sender.sendMessage(getMessage("reloadSuccess"));
                return true;
            } else {
                sender.sendMessage(getMessage("reloadNoPermission"));
                return true;
            }
        }
        return false;
    }
    private String getMessage(String key) {
        return plugin.getConfig().getString("messages." + key, "消息未定义: " + key);
    }
}

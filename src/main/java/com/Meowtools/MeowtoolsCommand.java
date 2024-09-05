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
        if (command.getName().equalsIgnoreCase("meowtools") && args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("meowtools..reload")) {
                plugin.loadConfig();
                sender.sendMessage("Meowtools配置已重新加载");
                return true;
            } else {
                sender.sendMessage("你没有权限执行此命令");
                return true;
            }
        }
        return false;
    }
}

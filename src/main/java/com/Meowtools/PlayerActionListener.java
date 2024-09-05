package com.Meowtools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class PlayerActionListener implements Listener {

    private final Xytool plugin;
    private final Set<Player> sneakingPlayers = new HashSet<>();

    public PlayerActionListener(Xytool plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (event.isSneaking()) {
            sneakingPlayers.add(player);
        } else {
            sneakingPlayers.remove(player);
        }
    }

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        handlePlayerAction(event.getPlayer(), event::setCancelled, true);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        handlePlayerAction(event.getPlayer(), event::setCancelled, false);
    }

    private void handlePlayerAction(Player player, Consumer<Boolean> cancelEvent, boolean isSwap) {
        float pitch = player.getLocation().getPitch();
        boolean isSneaking = sneakingPlayers.contains(player);
        Configuration config = plugin.getConfiguration();

        String command = null;
        boolean asConsole = false;

        if (isSneaking) {
            if (isSwap && !config.sneakSwapCommand.isEmpty()) {
                command = config.sneakSwapCommand;
                asConsole = config.sneakSwapAsConsole;
            } else if (!isSwap && !config.sneakDropCommand.isEmpty()) {
                command = config.sneakDropCommand;
                asConsole = config.sneakDropAsConsole;
            }
        } else if (pitch < -80) {
            if (isSwap && !config.lookUpSwapCommand.isEmpty()) {
                command = config.lookUpSwapCommand;
                asConsole = config.lookUpSwapAsConsole;
            } else if (!isSwap && !config.lookUpDropCommand.isEmpty()) {
                command = config.lookUpDropCommand;
                asConsole = config.lookUpDropAsConsole;
            }
        } else if (pitch > 80) {
            if (isSwap && !config.lookDownSwapCommand.isEmpty()) {
                command = config.lookDownSwapCommand;
                asConsole = config.lookDownSwapAsConsole;
            } else if (!isSwap && !config.lookDownDropCommand.isEmpty()) {
                command = config.lookDownDropCommand;
                asConsole = config.lookDownDropAsConsole;
            }
        }

        if (command != null) {
            cancelEvent.accept(true);
            executeCommand(player, command, asConsole);
        }
    }

    private void executeCommand(Player player, String command, boolean asConsole) {
        if (asConsole) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        } else {
            triggerPlayerCommand(player, command);
        }
    }

    private void triggerPlayerCommand(Player player, String command) {
        String commandWithSlash = "/" + command;
        PlayerCommandPreprocessEvent event = new PlayerCommandPreprocessEvent(player, commandWithSlash);
        Bukkit.getServer().getPluginManager().callEvent(event);

        if (!event.isCancelled()) {
            Bukkit.dispatchCommand(player, commandWithSlash.substring(1)); // 去掉斜杠
        }
    }
}


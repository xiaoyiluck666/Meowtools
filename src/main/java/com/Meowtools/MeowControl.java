package com.Meowtools;

import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class MeowControl implements Listener {

    private final JavaPlugin plugin;

    public MeowControl(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreeperPrime(ExplosionPrimeEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            boolean protectTerrain = plugin.getConfig().getBoolean("creeper.protectTerrain", true);
            boolean explodeAsFireworks = plugin.getConfig().getBoolean("creeper.explodeAsFireworks", false);

            if (protectTerrain) {
                event.setCancelled(true);  // 取消爆炸对地形的破坏
                event.getEntity().remove(); // 移除 Creeper 实体以防止爆炸
            }

            if (explodeAsFireworks) {
                spawnFireworks(event.getEntity().getLocation());
            }
        }
    }

    private void spawnFireworks(Location location) {
        // 发射烟花的逻辑
        World world = location.getWorld();
        if (world != null) {
            Firework firework = world.spawn(location, Firework.class);
            FireworkMeta fireworkMeta = firework.getFireworkMeta();
            Random random = new Random();

            FireworkEffect.Builder effectBuilder = FireworkEffect.builder()
                    .with(FireworkEffect.Type.values()[random.nextInt(FireworkEffect.Type.values().length)])
                    .withColor(org.bukkit.Color.fromRGB(random.nextInt(256), random.nextInt(256), random.nextInt(256)))
                    .flicker(random.nextBoolean())
                    .trail(random.nextBoolean());

            fireworkMeta.addEffect(effectBuilder.build());
            fireworkMeta.setPower(1);
            firework.setFireworkMeta(fireworkMeta);
        }
    }
}

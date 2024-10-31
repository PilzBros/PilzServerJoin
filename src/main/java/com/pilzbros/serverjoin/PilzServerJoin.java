package com.pilzbros.serverjoin;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class PilzServerJoin extends JavaPlugin implements Listener {
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent pje) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            public void run() {
                Firework f = (Firework)pje.getPlayer().getWorld().spawn(pje.getPlayer().getLocation(), Firework.class);
                FireworkMeta fm = f.getFireworkMeta();
                fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(Type.BALL).with(Type.BALL_LARGE).withColor(Color.BLACK).withColor(Color.GREEN).withFade(Color.PURPLE).withFade(Color.RED).withColor(Color.SILVER).build());
                fm.setPower(1);
                f.setFireworkMeta(fm);
            }
        }, 20L);
    }
}

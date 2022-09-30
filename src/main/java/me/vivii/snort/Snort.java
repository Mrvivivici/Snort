package me.vivii.snort;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public final class Snort extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent e) {
        PotionEffect Weakness=new PotionEffect(PotionEffectType.WEAKNESS,1200,3);
        PotionEffect Slowness=new PotionEffect(PotionEffectType.SLOW,1200,3);
        PotionEffect Nausea=new PotionEffect(PotionEffectType.CONFUSION,2400,10);
        if (e.hasItem()) {
            if (Objects.requireNonNull(e.getItem()).getType().equals(Material.AMETHYST_SHARD) && Objects.requireNonNull(e.getPlayer().getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equals("Blue Sky")) {
                e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
                e.getPlayer().addPotionEffect(Weakness);
                e.getPlayer().addPotionEffect(Slowness);
                e.getPlayer().addPotionEffect(Nausea);
            }
        }
    }
}

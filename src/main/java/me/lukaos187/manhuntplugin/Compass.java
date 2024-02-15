package me.lukaos187.manhuntplugin;

import me.lukaos187.manhuntplugin.commands.HunterCommand;
import me.lukaos187.manhuntplugin.commands.RunnerCommand;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Compass implements Listener {

    @EventHandler

    public void onEvent(PlayerInteractEvent event) {

        ItemStack playerTracker = event.getItem();
        ItemMeta trackerMeta = playerTracker.getItemMeta();

        if (trackerMeta.getDisplayName().equals(ChatColor.RED + "Player Tracker")) {

            RunnerCommand runner = new RunnerCommand();
            Location runnerLoc = runner.getRunnerLoc();
            HunterCommand hunterCommand = new HunterCommand();
            List<Player> hunters = hunterCommand.getHunters();
            hunters.forEach(player -> player.setCompassTarget(runnerLoc));
            hunters.forEach(player -> player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Tracking " + runner.getRunnerName())));

            Bukkit.broadcastMessage("uhgfuhuf");

        }

    }

}

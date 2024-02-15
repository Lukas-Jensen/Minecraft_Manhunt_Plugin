package me.lukaos187.manhuntplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class HunterCommand implements CommandExecutor {

    private List<Player> hunters = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player){

            Bukkit.broadcastMessage(sender.getName() + " is now " + ChatColor.RED + "Hunter");
            ((Player) sender).getInventory().clear();

            ItemStack playerTracker = new ItemStack(Material.COMPASS);
            ItemMeta cMeta = playerTracker.getItemMeta();
            cMeta.setDisplayName(ChatColor.RED + "Player Tracker");
            cMeta.addEnchant(Enchantment.DURABILITY, 10, true);
            playerTracker.setItemMeta(cMeta);
            ((Player) sender).getInventory().addItem(playerTracker);



        }else {
            Bukkit.getLogger().info("Du musst ein Spieler sein");
        }

        return false;
    }

    public List<Player> getHunters() {

        return hunters;
    }

}

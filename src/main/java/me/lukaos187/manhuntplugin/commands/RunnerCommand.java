package me.lukaos187.manhuntplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class RunnerCommand implements CommandExecutor {


    private Location runnerLoc;
    private String runnerName;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player target = (Player) sender;


        if (sender instanceof Player) {

            Bukkit.broadcastMessage(sender.getName() + " is now " + ChatColor.GREEN + "Runner");
            runnerLoc = target.getLocation();
            runnerName = target.getName();


        } else {
            Bukkit.getLogger().info("Du musst ein Spieler sein");
        }

        return false;
    }

    public Location getRunnerLoc() {
        return runnerLoc;
    }

    public String getRunnerName() {
        return runnerName;
    }
}

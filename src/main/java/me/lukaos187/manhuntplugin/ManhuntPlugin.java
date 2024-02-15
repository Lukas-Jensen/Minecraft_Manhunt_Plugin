package me.lukaos187.manhuntplugin;

import me.lukaos187.manhuntplugin.commands.HunterCommand;
import me.lukaos187.manhuntplugin.commands.RunnerCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ManhuntPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("hunter").setExecutor(new HunterCommand());
        getCommand("runner").setExecutor(new RunnerCommand());
        PluginManager pluginManager = this.getServer().getPluginManager();
        Compass listener = new Compass();
        pluginManager.registerEvents(listener, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

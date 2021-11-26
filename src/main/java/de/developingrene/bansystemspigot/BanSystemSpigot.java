package de.developingrene.bansystemspigot;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public final class BanSystemSpigot extends JavaPlugin {

    private static BanSystemSpigot plugin;

    @Override
    public void onEnable() {
        plugin = this;

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Listeners(), this);
        Bukkit.getServer().getLogger().log(Level.FINE, "Loaded Listeners");

        this.getCommand("pban").setExecutor(new BanCommands());
        Bukkit.getServer().getLogger().log(Level.FINE, "Loaded Commands");

    }

    @Override
    public void onDisable() {

    }

    protected static BanSystemSpigot getPlugin(){
        return plugin;
    }

    public static FileConfiguration getConfig(File file){
        return YamlConfiguration.loadConfiguration(file);
    }

}

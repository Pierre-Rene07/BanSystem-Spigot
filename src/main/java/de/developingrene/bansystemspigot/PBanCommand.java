package de.developingrene.bansystemspigot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PBanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false;
        Player p = ((Player) sender).getPlayer();

        Player target = Bukkit.getServer().getPlayer(args[0]);

        File f = new File(BanSystemSpigot.getPlugin().getDataFolder() + "/banned", target.getUniqueId() + ".yml");
        FileConfiguration config = BanSystemSpigot.getConfig(f);

        if (!p.hasPermission("bansystem.admin.pban")) {
            if (args.length == 2){

                if (config.getString("info.name") == null){
                    config.set("info.name", target.getName());
                }

                if (config.getString("info.reason") == null){
                    config.set("info.reason", args[1]);
                }

                if (config.getString("info.time") == null){
                    config.set("info.time", "Permanent");
                }

                try {
                    config.save(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}

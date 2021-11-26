package de.developingrene.bansystemspigot;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.File;

public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerLoginEvent e){
        Player p = e.getPlayer();
        if (hasIgnoreBanPermission(p)){
            e.allow();
            return;
        }

        if (isBanned(p)){
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED,"§4You are banned \n §4Reason: §8" + getReason(p) + "\n §4Unbanned in §8" + getTime(p) + " \n §3Server: §8Developing-Rene.de \n §aPlugin by Developing_Rene");
            return;
        }

        e.allow();

    }

    private static boolean hasIgnoreBanPermission(Player p){
        if (p.hasPermission(Permissions.IGNORE_BAN.getPerm())){
            return true;
        } else if (p.isOp()){
            return true;
        }

        return false;
    }

    private static boolean isBanned(Player p){

        File f = new File(BanSystemSpigot.getPlugin().getDataFolder() + "/banned", p.getUniqueId() + ".yml");
        FileConfiguration config = BanSystemSpigot.getConfig(f);

        if(f.exists()){
            return true;
        }

        return false;

    }

    private static String getReason(Player p){
        File f = new File(BanSystemSpigot.getPlugin().getDataFolder() + "/banned", p.getUniqueId() + ".yml");
        FileConfiguration config = BanSystemSpigot.getConfig(f);
        return config.getString("info.reason");
    }

    private static String getTime(Player p){
        File f = new File(BanSystemSpigot.getPlugin().getDataFolder() + "/banned", p.getUniqueId() + ".yml");
        FileConfiguration config = BanSystemSpigot.getConfig(f);
        return config.getString("info.time");
    }

}

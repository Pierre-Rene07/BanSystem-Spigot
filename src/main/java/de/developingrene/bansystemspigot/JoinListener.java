package de.developingrene.bansystemspigot;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerLoginEvent e){
        Player p = e.getPlayer();
        if (hasIgnoreBanPermission(p)){

        }
    }

    private static boolean hasIgnoreBanPermission(Player p){
        if (p.hasPermission(Permissions.IGNORE_BAN.getPerm())){
            return true;
        } else if (p.isOp()){
            return true;
        }

        return false;
    }

}

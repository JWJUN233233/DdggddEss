package ddggddess.ddggddess.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class exit implements Listener {
    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event){
        event.setQuitMessage("");
        Bukkit.broadcastMessage("§7[§c-§7]§r" + event.getPlayer().getDisplayName());
    }
}

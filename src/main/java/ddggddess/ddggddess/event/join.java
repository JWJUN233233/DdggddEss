package ddggddess.ddggddess.event;

import ddggddess.ddggddess.other.NameTranslate;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class join implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        event.setJoinMessage("§7[§a+§7]§r" + NameTranslate.Translate(event.getPlayer().getDisplayName(), event.getPlayer()));
    }
}

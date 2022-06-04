package ddggddess.ddggddess.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveName implements Listener {
    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent e){
        //Entity entity = Bukkit.getWorld(e.getPlayer().getWorld().getName()).spawnEntity(e.getPlayer().getLocation(), EntityType.ARMOR_STAND);
        //entity.setCustomNameVisible(true);
        //entity.setCustomName(e.getPlayer().getDisplayName());
    }
}

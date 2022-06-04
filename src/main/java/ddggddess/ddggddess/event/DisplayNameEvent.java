package ddggddess.ddggddess.event;

import ddggddess.ddggddess.DdggddEss;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class DisplayNameEvent implements Listener {
    @EventHandler
    public void onPlayerJoinServer(PlayerJoinEvent event){
        JavaPlugin config =  ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> namelist = config.getConfig().getStringList("DisplayName");
        for (int i = 0;i<namelist.size()/2;i++){
            if(event.getPlayer().getName().equals(namelist.get(i * 2))){
                event.getPlayer().setDisplayName(namelist.get(i * 2 + 1));
            }
        }
    }
}

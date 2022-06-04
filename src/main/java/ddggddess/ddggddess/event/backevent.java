package ddggddess.ddggddess.event;

import ddggddess.ddggddess.DdggddEss;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public class backevent implements Listener {
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> list = config.getConfig().getStringList("back");
        if(list.contains(e.getEntity().getName())){
            for(int i = 0;i<list.size()/5;i++){
                if (Objects.equals(list.get(i * 5), e.getEntity().getName())){
                    list.remove(i * 5);
                    list.remove(i * 5);
                    list.remove(i * 5);
                    list.remove(i * 5);
                    list.remove(i * 5);
                }
            }
        }
        list.add(e.getEntity().getName());
        Location location = e.getEntity().getLocation();
        String x = String.valueOf(location.getX());
        String y = String.valueOf(location.getY());
        String z = String.valueOf(location.getZ());
        World world = e.getEntity().getWorld();
        list.add(x);
        list.add(y);
        list.add(z);
        list.add(world.getName());
        config.getConfig().set("back",list);
    }
    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent e){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> list = config.getConfig().getStringList("back");
        if(list.contains(e.getPlayer().getName())){
            for(int i = 0;i<list.size()/5;i++){
                if (Objects.equals(list.get(i * 5), e.getPlayer().getName())){
                    list.remove(i * 5);
                    list.remove(i * 5);
                    list.remove(i * 5);
                    list.remove(i * 5);
                    list.remove(i * 5);
                }
            }
        }
        list.add(e.getPlayer().getName());
        Location location = e.getPlayer().getLocation();
        String x = String.valueOf(location.getX());
        String y = String.valueOf(location.getY());
        String z = String.valueOf(location.getZ());
        World world = e.getPlayer().getWorld();
        list.add(x);
        list.add(y);
        list.add(z);
        list.add(world.getName());
        config.getConfig().set("back",list);
    }
}

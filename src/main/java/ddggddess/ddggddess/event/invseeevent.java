package ddggddess.ddggddess.event;

import ddggddess.ddggddess.DdggddEss;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public class invseeevent implements Listener {
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> invconfig = config.getConfig().getStringList("invsee");
        for(int i = 0;i<invconfig.size()/2;i++) {
            if (event.getWhoClicked().getName().equals(invconfig.get(i * 2))){
                Player player = Bukkit.getPlayer(invconfig.get(i * 2 + 1));
                for (int j = 0;j<36;j++){
                    assert player != null;
                    player.getInventory().setItem(j,event.getInventory().getItem(j));
                    player.updateInventory();
                }
            }
            else if(Objects.equals(invconfig.get(2 * i + 1), event.getWhoClicked().getName())){
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onInventoryDragEvent(InventoryDragEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> invconfig = config.getConfig().getStringList("invsee");
        for(int i = 0;i<invconfig.size()/2;i++) {
            if(Objects.equals(invconfig.get(2 * i + 1), event.getWhoClicked().getName())){
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> invconfig = config.getConfig().getStringList("invsee");
        for(int i = 0;i<invconfig.size()/2;i++) {
            if(Objects.equals(invconfig.get(2 * i + 1), event.getPlayer().getName())){
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> invconfig = config.getConfig().getStringList("invsee");
        for(int i = 0;i<invconfig.size()/2;i++) {
            if(Objects.equals(invconfig.get(2 * i + 1), event.getPlayer().getName())){
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) {
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> invconfig = config.getConfig().getStringList("invsee");
        for(int i = 0;i<invconfig.size()/2;i++) {
            if (event.getPlayer().getName().equals(invconfig.get(i * 2))) {
                Player player = Bukkit.getPlayer(invconfig.get(i * 2 + 1));
                for (int j = 0; j < 36; j++) {
                    assert player != null;
                    player.getInventory().setItem(j, event.getInventory().getItem(j));
                    player.updateInventory();
                }

            }
        }
        for (int i = 0; i < invconfig.size() / 2; i++) {
            if (Objects.equals(invconfig.get(i * 2), event.getPlayer().getName())){
                invconfig.remove(i * 2);
                invconfig.remove(i * 2);
            }
        }
        config.getConfig().set("invsee",invconfig);
    }
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> invconfig = config.getConfig().getStringList("invsee");
        for(int i = 0;i<invconfig.size()/2;i++) {
            if(Objects.equals(invconfig.get(2 * i + 1), event.getPlayer().getName())){
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onInventoryDragEvent(BlockPlaceEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> invconfig = config.getConfig().getStringList("invsee");
        for(int i = 0;i<invconfig.size()/2;i++) {
            if(Objects.equals(invconfig.get(2 * i + 1), event.getPlayer().getName())){
                event.setCancelled(true);
            }
        }
    }
}


package ddggddess.ddggddess.event;

import ddggddess.ddggddess.DdggddEss;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public class lock implements Listener {
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0; i< lockconfig.size(); i++) {
            if(Objects.equals(lockconfig.get(i), event.getWhoClicked().getName())){
                event.setCancelled(true);
                ((Player)event.getWhoClicked()).sendTitle("§e你被铐住了","§c你不可以动你的物品",0,100,0);
            }
        }
    }
    @EventHandler
    public void onInventoryDragEvent(InventoryDragEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0; i< lockconfig.size(); i++) {
            if(Objects.equals(lockconfig.get(i), event.getWhoClicked().getName())){
                event.setCancelled(true);
                ((Player)event.getWhoClicked()).sendTitle("§e你被铐住了","§c你不可以动你的物品",0,100,0);
            }
        }
    }
    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0; i< lockconfig.size(); i++) {
            if(Objects.equals(lockconfig.get(i), event.getPlayer().getName())){
                event.setCancelled(true);
                event.getPlayer().sendTitle("§e你被铐住了","§c你不可以动你的物品",0,100,0);
            }
        }
    }
    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0;i<lockconfig.size();i++) {
            if(Objects.equals(lockconfig.get(i), event.getPlayer().getName())){
                event.setCancelled(true);
                event.getPlayer().sendTitle("§e你被铐住了","§c你不可以动你的物品",0,100,0);
            }
        }
    }
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0;i<lockconfig.size();i++) {
            if(Objects.equals(lockconfig.get(i), event.getPlayer().getName())){
                event.setCancelled(true);
                event.getPlayer().sendTitle("§e你被铐住了","§c你不可以摧毁方块",0,100,0);
            }
        }
    }
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0;i<lockconfig.size();i++) {
            if(Objects.equals(lockconfig.get(i), event.getPlayer().getName())){
                event.setCancelled(true);
                event.getPlayer().sendTitle("§e你被铐住了","§c你不可以放置方块",0,100,0);
            }
        }
    }
    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0;i<lockconfig.size();i++) {
            if(Objects.equals(lockconfig.get(i), event.getPlayer().getName())){
                event.setCancelled(true);
                event.getPlayer().sendTitle("§e你被铐住了","§c你不可以移动",0,100,0);
            }
        }
    }
    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0;i<lockconfig.size();i++) {
            if(Objects.equals(lockconfig.get(i), event.getPlayer().getName())){
                event.setCancelled(true);
                event.getPlayer().sendTitle("§e你被铐住了","§c你不可以传送",0,100,0);
            }
        }
    }
    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> lockconfig = config.getConfig().getStringList("lockplayer");
        for(int i = 0;i<lockconfig.size();i++) {
            if(Objects.equals(lockconfig.get(i), event.getPlayer().getName())){
                event.setCancelled(true);
                event.getPlayer().sendTitle("§e你被铐住了","§c你不可以使用命令",0,100,0);
            }
        }
    }
}


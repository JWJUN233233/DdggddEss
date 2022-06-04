package ddggddess.ddggddess.event;

import ddggddess.ddggddess.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public class HomesGui implements Listener {
    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent e){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> open = config.getConfig().getStringList("home_open");
        if(open.contains(e.getPlayer().getName())){
            open.remove(e.getPlayer().getName());
        }
        config.getConfig().set("home_open",open);
    }
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e){
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> open = config.getConfig().getStringList("home_open");
        Location location;
        if(open.contains(e.getWhoClicked().getName())){
            e.setCancelled(true);
            if(e.isRightClick() & e.isShiftClick()){
                List<String> homes =  config.getConfig().getStringList("home");
                for (int i = 0;i<homes.size()/6;i++) {
                    boolean b = e.getCurrentItem().getItemMeta().getDisplayName().equals("§f" + homes.get(i * 6 + 5));
                    if (Objects.equals(homes.get(i * 6), e.getWhoClicked().getName()) & b) {
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        config.getConfig().set("home",homes);
                        e.getWhoClicked().closeInventory();
                        homegui.gui(e.getWhoClicked(),new String[]{});
                    }
                    }
                }
            else{List<String> homes =  config.getConfig().getStringList("home");
                for (int i = 0;i<homes.size()/6;i++) {
                    boolean b = e.getCurrentItem().getItemMeta().getDisplayName().equals("§f" + homes.get(i * 6 + 5));
                    if (Objects.equals(homes.get(i * 6), e.getWhoClicked().getName()) & b) {
                        double x = Double.parseDouble(homes.get(i * 6 + 1));
                        double y = Double.parseDouble(homes.get(i * 6 + 2));
                        double z = Double.parseDouble(homes.get(i * 6 + 3));
                        World world = Bukkit.getWorld(homes.get(i * 6 + 4));
                        location = new Location(world,x,y,z);
                        e.getWhoClicked().closeInventory();
                        e.getWhoClicked().teleport(location);}
                }
            }
        }
    }
}

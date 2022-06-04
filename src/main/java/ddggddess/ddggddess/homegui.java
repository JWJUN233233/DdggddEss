package ddggddess.ddggddess;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class homegui {
    public static boolean gui(CommandSender sender,String[] args){
        if(sender instanceof Player){
            if(args.length == 0){
                JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
                List<String> homes =  config.getConfig().getStringList("home");
                Inventory gui= Bukkit.createInventory(null,3*9,((Player)sender).getDisplayName() + "§e的家");
                for (int i = 0;i<homes.size()/6;i++){
                    if(Objects.equals(homes.get(i * 6), sender.getName())){
                        double x = Double.parseDouble(homes.get(i * 6 + 1));
                        double y = Double.parseDouble(homes.get(i * 6 + 2));
                        double z = Double.parseDouble(homes.get(i * 6 + 3));
                        String lore = homes.get(i * 6 + 5);
                        World world = Bukkit.getWorld(homes.get(i * 6 + 4));
                        ItemStack guione;
                        List<String> tmp = new ArrayList<>();
                        if(Objects.equals(homes.get(i * 6 + 4), "world")){
                            guione = new ItemStack(Material.GRASS_BLOCK);
                            ItemMeta meta = guione.getItemMeta();
                            tmp.add("§f名称:" + lore);
                            tmp.add("§fX:" + String.valueOf(x));
                            tmp.add("§fY:" + String.valueOf(y));
                            tmp.add("§fZ:" + String.valueOf(z));
                            tmp.add("§f世界:" + world.getName());
                            tmp.add("§cShift + 右键删除");
                            meta.setLore(tmp);
                            meta.setDisplayName("§f" + lore);
                            guione.setItemMeta(meta);
                            gui.addItem(guione);
                        }
                        else if(Objects.equals(homes.get(i * 6 + 4), "world_nether")){
                            guione = new ItemStack(Material.NETHERRACK);
                            ItemMeta meta = guione.getItemMeta();
                            tmp.add("§f名称:" + lore);
                            tmp.add("§fX:" + String.valueOf(x));
                            tmp.add("§fY:" + String.valueOf(y));
                            tmp.add("§fZ:" + String.valueOf(z));
                            tmp.add("§f世界:" + world.getName());
                            tmp.add("§cShift + 右键删除");
                            meta.setLore(tmp);
                            meta.setDisplayName("§f" + lore);
                            guione.setItemMeta(meta);
                            gui.addItem(guione);
                        }
                        else if(Objects.equals(homes.get(i * 6 + 4), "world_the_end")){
                            guione = new ItemStack(Material.END_STONE);
                            ItemMeta meta = guione.getItemMeta();
                            tmp.add("§f名称:" + lore);
                            tmp.add("§fX:" + String.valueOf(x));
                            tmp.add("§fY:" + String.valueOf(y));
                            tmp.add("§fZ:" + String.valueOf(z));
                            tmp.add("§f世界:" + world.getName());
                            tmp.add("§cShift + 右键删除");
                            meta.setLore(tmp);
                            meta.setDisplayName("§f" + lore);
                            guione.setItemMeta(meta);
                            gui.addItem(guione);
                        }
                        else{
                            guione = new ItemStack(Material.BEDROCK);
                            ItemMeta meta = guione.getItemMeta();
                            tmp.add("§f名称:" + lore);
                            tmp.add("§fX:" + String.valueOf(x));
                            tmp.add("§fY:" + String.valueOf(y));
                            tmp.add("§fZ:" + String.valueOf(z));
                            tmp.add("§f世界:" + world.getName());
                            tmp.add("§cShift + 右键删除");
                            meta.setLore(tmp);
                            meta.setDisplayName("§f" + lore);
                            guione.setItemMeta(meta);
                            gui.addItem(guione);
                        }
                    }
                }
                ((Player) sender).openInventory(gui);
                List<String> openhomes =  config.getConfig().getStringList("home_open");
                openhomes.add(sender.getName());
                config.getConfig().set("home_open",openhomes);
            }
            else if(args.length == 1){
                JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
                List<String> homes =  config.getConfig().getStringList("home");
                for(int i = 0;i<homes.size()/6;i++){
                    if(Objects.equals(homes.get(i * 6), sender.getName()) & Objects.equals(homes.get(i * 6 + 5), args[0])){
                        double x = Double.parseDouble(homes.get(i * 6 + 1));
                        double y = Double.parseDouble(homes.get(i * 6 + 2));
                        double z = Double.parseDouble(homes.get(i * 6 + 3));
                        World world = Bukkit.getWorld(homes.get(i * 6 + 4));
                        Location location = new Location(world,x,y,z);
                        ((Player)sender).teleport(location);}
                    }
                }
            }
        else {
            sender.sendMessage("此命令只支持玩家使用");
        }return false;
    }
}

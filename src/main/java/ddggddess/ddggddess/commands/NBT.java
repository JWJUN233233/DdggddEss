package ddggddess.ddggddess.commands;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NBT implements CommandExecutor , TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            if(((Player)commandSender).getInventory().getItemInMainHand().getType() != Material.AIR){
                if(strings.length == 2){
                    NBTItem NBTI = new NBTItem(((Player)commandSender).getInventory().getItemInMainHand());
                    NBTI.setString(strings[0],strings[1]);
                    ((Player) commandSender).getInventory().setItemInMainHand(NBTI.getItem());
                }
            }
            else{
                commandSender.sendMessage("§e你确定你手上有物品?");
            }
        }
        else{
            commandSender.sendMessage("§e此命令只支持玩家使用");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1 & ((Player)commandSender).getInventory().getItemInMainHand().getType() != Material.AIR){
            Set<String> Keys = new NBTItem(((Player)commandSender).getInventory().getItemInMainHand()).getKeys();
            return new ArrayList<>(Keys);
        }
        if(strings.length == 2 & ((Player)commandSender).getInventory().getItemInMainHand().getType() != Material.AIR){
            List<String> returns = new ArrayList<>();
            if(new NBTItem(((Player)commandSender).getInventory().getItemInMainHand()).hasKey(strings[0])) {
                returns.add(new NBTItem(((Player) commandSender).getInventory().getItemInMainHand()).getString(strings[0]));
            }
            else{
                returns.add("value");
            }
            return returns;
        }
        return new ArrayList<>();
    }
}

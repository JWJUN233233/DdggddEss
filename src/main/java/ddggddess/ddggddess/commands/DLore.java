package ddggddess.ddggddess.commands;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DLore implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            if (((Player) commandSender).getInventory().getItemInMainHand().getType() != Material.AIR) {
                ItemStack item = ((Player) commandSender).getInventory().getItemInMainHand();
                NBTItem nbti = new NBTItem(item);
                nbti.setBoolean("UseDlore", true);
                int c = 1;
                while (true) {
                    if (nbti.hasKey("Dlore" + c)) {
                        nbti.removeKey("Dlore" + c);
                    } else {
                        break;
                    }
                    c++;
                }
                for (int i = 0; i < strings.length; i++) {
                    nbti.setString("Dlore" + (i + 1), strings[i]);
                }
                ((Player) commandSender).getInventory().setItemInMainHand(nbti.getItem());
            } else {
                commandSender.sendMessage("§e你确定你手上有物品?");
            }

        }else{commandSender.sendMessage("§e你确定你是玩家?");}
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}

package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.other.NameTranslate;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DName implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            if(((Player) commandSender).getInventory().getItemInMainHand().getType() != Material.AIR) {
                ItemStack itemStack = ((Player) commandSender).getInventory().getItemInMainHand();
                NBTItem NBTI = new NBTItem(itemStack);
                if (strings.length == 0) {
                    NBTI.removeKey("DName");
                }
                ;
                NBTI.setString("DName", strings[0]);
                ((Player) commandSender).getInventory().setItemInMainHand(NBTI.getItem());
            }
            else{
                commandSender.sendMessage("§e你确定你手上有物品?");
            }
        }
        else{
            commandSender.sendMessage(NameTranslate.Translate("§e此命令只有玩家可用"));
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}

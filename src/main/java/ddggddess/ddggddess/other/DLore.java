package ddggddess.ddggddess.other;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DLore implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ItemStack item = ((Player)commandSender).getInventory().getItemInMainHand();
        NBTItem nbti = new NBTItem(item);
        nbti.setBoolean("UseDlore",true);
        int c = 1;
        while (true) {
            if (nbti.hasKey("Dlore" + c)) {
                nbti.removeKey("Dlore" + c);
            } else {
                break;
            }
            c++;
        }
        for(int i = 0;i < strings.length;i++){
            nbti.setString("Dlore" + (i + 1),strings[i]);
        }
        ((Player)commandSender).getInventory().setItemInMainHand(nbti.getItem());
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}

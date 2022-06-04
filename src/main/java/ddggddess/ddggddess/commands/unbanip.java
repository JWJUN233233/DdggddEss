package ddggddess.ddggddess.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class unbanip implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if (sender.hasPermission("unbanip")) {
            if (Bukkit.getBanList(BanList.Type.IP).isBanned(args[0])) {
                BanList ban = Bukkit.getBanList(BanList.Type.IP);
                ban.pardon(args[0]);
                sender.sendMessage("§c成功解除ip封禁");
            } else {
                sender.sendMessage("§c此ip没有被封禁");
            }
        }
        else{
            sender.sendMessage("§c你没有权限");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias,String[] args) {
        List<String> tab = new ArrayList<String>();
        if(args.length == 1){
            return null;
        }
        return tab;
    }
}

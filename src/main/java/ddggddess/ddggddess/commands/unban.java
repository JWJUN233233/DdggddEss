package ddggddess.ddggddess.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class unban implements CommandExecutor , TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if (sender.hasPermission("unban")) {
            if (Bukkit.getBanList(BanList.Type.NAME).isBanned(args[0])) {
                BanList ban = Bukkit.getBanList(BanList.Type.NAME);
                ban.pardon(args[0]);
                sender.sendMessage("§c成功解除封禁");
            } else {
                sender.sendMessage("§c此玩家没有被封禁");
            }
        }
        else{
            sender.sendMessage("§c你没有权限");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<String>();
        if(args.length == 1){
            return null;
        }
        return tab;
    }
}

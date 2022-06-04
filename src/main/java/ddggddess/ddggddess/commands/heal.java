package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.Player.isplayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class heal implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if (sender.hasPermission("heal")) {
        if(args.length == 0){
            if (sender instanceof Player){
                ((Player) sender).setHealth(20);
            }
            else{
                sender.sendMessage("§c此命令只支持玩家使用");
            }
        }
        else {
            if (isplayer.IsHavePlayer(args[0]) & args.length == 1) {
                Bukkit.getPlayer(args[0]).setHealth(20);
            } else {
                sender.sendMessage("§c玩家不存在或不在线");
            }
        }}
        else{
            sender.sendMessage("§c你没有权限");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if(args.length == 1){
            return null;
        }
        return tab;
    }
}

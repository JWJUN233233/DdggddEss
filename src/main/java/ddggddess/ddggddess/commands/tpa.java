package ddggddess.ddggddess.commands;
import ddggddess.ddggddess.DdggddEss;
import ddggddess.ddggddess.Player.isplayer;
import ddggddess.ddggddess.other.tpask;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
public class tpa implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(isplayer.IsHavePlayer(args[0])) {
        if (args.length == 1) {
            if (sender instanceof Player){
                Player sender1 = Bukkit.getPlayer(sender.getName());
                Player p2 = Bukkit.getPlayer(args[0]);
                tpask.createAsk(sender1,p2, tpask.tptype.tpa);
            }
            else {
                sender.sendMessage("§etpa命令只允许玩家使用");
            }
        }
        else {
            sender.sendMessage("§e命令格式不正确，请使用help命令查看帮助");
        }
        }
        else {
        sender.sendMessage("§c玩家不存在或不在线");
    }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command,String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if(args.length == 1){
            return null;
        }
        return tab;
    }
}
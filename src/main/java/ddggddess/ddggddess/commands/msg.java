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
import java.util.Objects;

public class msg implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if(isplayer.IsHavePlayer(args[0])) {
            if (args.length == 2) {
                sender.sendMessage("§7[me -> §r" + Objects.requireNonNull(Bukkit.getServer().getPlayer(args[0])).getDisplayName() + "§7] §r" + args[1].replaceAll("&","§"));
                Objects.requireNonNull(Bukkit.getServer().getPlayer(args[0])).sendMessage("§7[§r" + ((Player) sender).getDisplayName() + "§7 -> me] §r" + args[1].replaceAll("&","§"));
            }
        else{
            Objects.requireNonNull(Bukkit.getServer().getPlayer(args[0])).sendMessage("§7[§dServer§7 -> me] §r" + args[1].replaceAll("&","§"));
        }
            } else {
                sender.sendMessage("§c玩家不存在或不在线");
            }
        }return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1){
            return null;
        }
        if (args.length == 2) {
            tab.add("<msg>");
        }
        return tab;
    }
}

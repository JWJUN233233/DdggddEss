package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.Player.isplayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class gm implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand( CommandSender sender,Command command,String label, String[] args) {
        if (sender.hasPermission("gm")) {
            if (args.length == 1) {
                if (sender instanceof Player) {
                    if (Objects.equals(args[0], "1")) {
                        ((Player) sender).setGameMode(GameMode.CREATIVE);
                    }
                    if (Objects.equals(args[0], "0")) {
                        ((Player) sender).setGameMode(GameMode.SURVIVAL);
                    }
                    if (Objects.equals(args[0], "2")) {
                        ((Player) sender).setGameMode(GameMode.ADVENTURE);
                    }
                    if (Objects.equals(args[0], "3")) {
                        ((Player) sender).setGameMode(GameMode.SPECTATOR);
                    }
                } else {
                    sender.sendMessage("此命令只支持玩家使用");
                }
            }
            else if(isplayer.IsHavePlayer(args[1])) {
                if (args.length == 2) {
                    if (Objects.equals(args[0], "1")) {
                        Bukkit.getPlayer(args[1]).setGameMode(GameMode.CREATIVE);
                    }
                    if (Objects.equals(args[0], "0")) {
                        Bukkit.getPlayer(args[1]).setGameMode(GameMode.SURVIVAL);
                    }
                    if (Objects.equals(args[0], "2")) {
                        Bukkit.getPlayer(args[1]).setGameMode(GameMode.ADVENTURE);
                    }
                    if (Objects.equals(args[0], "3")) {
                        Bukkit.getPlayer(args[1]).setGameMode(GameMode.SPECTATOR);
                    }
                }
            } else {
            sender.sendMessage("§c玩家不存在或不在线");
        }
        }
        else{
            sender.sendMessage("§c你没有权限");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender,Command command,String alias,String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1){
            tab.add("0");
            tab.add("1");
            tab.add("2");
            tab.add("3");
        }
        if (args.length == 2){
            return null;
        }
        return tab;
    }
}

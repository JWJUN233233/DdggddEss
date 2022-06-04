package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.DdggddEss;
import ddggddess.ddggddess.Player.isplayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class chatcolor implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
        if (sender.hasPermission("chatcolor")) {
            if (args.length == 2) {
                if (sender instanceof Player) {
                    String arg1 = args[0];
                    String arg2 = args[1];
                    List<String> colors = config.getConfig().getStringList("chatcolor");
                    for (int i = 0; i < colors.size() / 3; i++) {
                        if (Objects.equals(colors.get(i * 3), sender.getName())) {
                            colors.remove(i * 3);
                            colors.remove(i * 3);
                            colors.remove(i * 3);
                            break;
                        }
                    }
                    colors.add(sender.getName());
                    colors.add(arg1.replaceAll("&","§").replaceAll("§§","&"));
                    colors.add(arg2.replaceAll("&","§").replaceAll("§§","&"));
                    config.getConfig().set("chatcolor", colors);
                } else {
                    sender.sendMessage("§e此命令只支持玩家使用");
                }
            }
            if (args.length == 3) {
                if(isplayer.IsHavePlayer(args[2])) {
                    String arg1 = args[0];
                    String arg2 = args[1];
                    List<String> colors = config.getConfig().getStringList("chatcolor");
                    for (int i = 0; i < colors.size() / 3; i++) {
                        if (Objects.equals(colors.get(i * 3), args[2])) {
                            colors.remove(i * 3);
                            colors.remove(i * 3);
                            colors.remove(i * 3);
                            break;
                        }
                    }
                    colors.add(args[2]);
                    colors.add(arg1.replaceAll("&","§").replaceAll("§§","&"));
                    colors.add(arg2.replaceAll("&","§").replaceAll("§§","&"));
                    config.getConfig().set("chatcolor", colors);
                }else{
                    sender.sendMessage("§c玩家不存在或不在线");
                }
            }
        }
        else{
            sender.sendMessage("§c你没有权限");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> tab = new ArrayList<>();
        if(strings.length == 3){
            return null;
        }
        return tab;
    }
}

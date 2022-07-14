package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.DdggddEss;
import ddggddess.ddggddess.Player.isplayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class chatnickname implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
        if (sender.hasPermission("chatnickname")) {
            String arg1 = args[0].replaceAll("&", "§") + "§r";
            if (args.length == 1) {
                if (sender instanceof Player) {
                    List<String> namelist = config.getConfig().getStringList("chatnickname");
                    for (int i = 0; i < namelist.size() / 2; i++) {
                        if (Objects.equals(namelist.get(i * 2), sender.getName())) {
                            namelist.remove(i * 2);
                            namelist.remove(i * 2);
                            break;
                        }
                    }
                    namelist.add(sender.getName());
                    namelist.add(arg1);
                    config.getConfig().set("chatnickname", namelist);
                } else {
                    sender.sendMessage("§e此命令只支持玩家使用");
                }
            }
            if (args.length == 2) {
                if(isplayer.IsHavePlayer(args[1])) {
                    List<String> namelist = config.getConfig().getStringList("chatnickname");
                    for (int i = 0; i < namelist.size() / 2; i++) {
                        if (Objects.equals(namelist.get(i * 2), args[1])) {
                            namelist.remove(i * 2);
                            namelist.remove(i * 2);
                            break;
                        }
                    }
                    namelist.add(args[1]);
                    namelist.add(arg1);
                    config.getConfig().set("chatnickname", namelist);
                }else{
                    sender.sendMessage("§c玩家不存在或不在线");
                }
                {

                }
            }
        }
        else{
            sender.sendMessage("§c你没有权限");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias,String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1){
            tab.add("<champion>");

        }
        if (args.length == 2){
            return null;
        }
        return tab;
    }
}

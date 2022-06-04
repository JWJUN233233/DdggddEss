package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.DdggddEss;
import ddggddess.ddggddess.Player.isplayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class lockplayer implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand( CommandSender sender, Command command,String label, String[] args) {
        if (sender.hasPermission("lockplayer")) {
            if(isplayer.IsHavePlayer(args[0])) {
                if (args.length == 1) {
                    JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
                    List<String> lockconfig = config.getConfig().getStringList("lockplayer");
                    if (!lockconfig.contains(args[0])) {
                        lockconfig.add(args[0]);
                        sender.sendMessage("§e已铐住此玩家");
                    } else {
                        for (int i = 0; i < lockconfig.size(); i++) {
                            if (Objects.equals(lockconfig.get(i), args[0])) {
                                lockconfig.remove(i);
                                break;
                            }
                        }
                        sender.sendMessage("§e已解锁此玩家");
                    }
                    config.getConfig().set("lockplayer", lockconfig);
                } else {
                    sender.sendMessage("§e命令参数不正确");
                }

            } else {
                sender.sendMessage("§c玩家不存在或不在线");
            }

    }else{
            sender.sendMessage("§c你没有权限");
        }return false;}
    @Override
    public List<String> onTabComplete(CommandSender sender,  Command command,  String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if(args.length == 1){
            return null;
        }
        return tab;
    }
}

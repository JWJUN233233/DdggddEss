package ddggddess.ddggddess.commands;

import com.Zrips.CMI.CMI;
import com.Zrips.CMI.Modules.NickName.NickNameManager;
import ddggddess.ddggddess.DdggddEss;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ddggddess.ddggddess.Player.isplayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DisplayName implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args) {
        if (sender.hasPermission("displayname")) {
            if (args.length == 1) {
                if (sender instanceof Player) {
                    NickNameManager name = new NickNameManager(CMI.getPlugin(CMI.class));
                    name.addNewNickName(args[0],((Player)sender).getUniqueId());
                } else {
                    sender.sendMessage("§e此命令只支持玩家使用");
                }
            }
            if (args.length == 2) {
                if(isplayer.IsHavePlayer(args[1])) {
                    NickNameManager name = new NickNameManager(CMI.getPlugin(CMI.class));
                    name.addNewNickName(args[0], Objects.requireNonNull(Bukkit.getPlayer(args[1])).getUniqueId());
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
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1){
            tab.add("<Name>");
            return tab;
        }
        if(args.length == 2){
        return null;
        }
        return tab;
    }
}

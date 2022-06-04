package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.DdggddEss;
import ddggddess.ddggddess.Player.isplayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class invsee implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand( CommandSender sender, Command command,String label, String[] args) {
        if (sender.hasPermission("invsee")){
        if(sender instanceof Player) {
            if(isplayer.IsHavePlayer(args[0])) {
            if(args.length == 1){
            JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
            List<String> invconfig = config.getConfig().getStringList("invsee");
            Player player = Bukkit.getPlayer(args[0]);
            Inventory gui = Bukkit.createInventory(null, 4 * 9, player.getDisplayName() + "§r的背包");
            for (int i = 0; i < 36; i++) {
                gui.setItem(i, player.getInventory().getItem(i));
            }
            invconfig.add(sender.getName());
            invconfig.add(args[0]);
            ((Player) sender).openInventory(gui);
            config.getConfig().set("invsee",invconfig);
            }
            else{
                sender.sendMessage("§e命令参数不正确");
            }
        } else {
                sender.sendMessage("§c玩家不存在或不在线");
            }}
        else{
            sender.sendMessage("§e此命令只允许玩家使用");
        }}
        else{
            sender.sendMessage("§c你没有权限");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender,  Command command,  String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if(args.length == 1){
            return null;
        }
        return tab;
    }
}

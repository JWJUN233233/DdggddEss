package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.DdggddEss;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class sethome implements CommandExecutor , TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length >= 1){
            JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
            List<String> homes =  config.getConfig().getStringList("home");
                for (int i = 0;i<homes.size()/6;i++) {
                    if(homes.get(i * 6) == sender.getName() & homes.get(i * 6 + 5) == args[0]){
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                        homes.remove(i * 6);
                    }
                }
            homes.add(sender.getName());
            Location location = ((Player)sender).getLocation();
            String x = String.valueOf(location.getX());
            String y = String.valueOf(location.getY());
            String z = String.valueOf(location.getZ());
            World world = ((Player)sender).getWorld();
            homes.add(x);
            homes.add(y);
            homes.add(z);
            homes.add(world.getName());
            homes.add(args[0]);
                sender.sendMessage("§e成功创建Home：§r" + args[0]);
                config.getConfig().set("home",homes);
            }
        }else {
            sender.sendMessage("此命令只支持玩家使用");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return new ArrayList<>();
    }
}

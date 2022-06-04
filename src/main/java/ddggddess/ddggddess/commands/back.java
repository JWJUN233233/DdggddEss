package ddggddess.ddggddess.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

import static ddggddess.ddggddess.commands.DdggddEss.*;
import static org.bukkit.plugin.java.JavaPlugin.getProvidingPlugin;

public class back implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if(sender instanceof Player){
            JavaPlugin config = getProvidingPlugin(DdggddEss.class);
            List<String> BackList = config.getConfig().getStringList("back");
            if(BackList.contains(sender.getName())){
                for(int i = 0;i<BackList.size()/5;i++){
                    if(Objects.equals(BackList.get(i * 5), sender.getName())){
                        double x = Double.parseDouble(BackList.get(i * 5 + 1));
                        double y = Double.parseDouble(BackList.get(i * 5 + 2));
                        double z = Double.parseDouble(BackList.get(i * 5 + 3));
                        World world = Bukkit.getWorld(BackList.get(i * 5 + 4));
                        Location location = new Location(world,x,y,z);
                        ((Player) sender).teleport(location);
                    }
                }
            }
        }
        else {
            sender.sendMessage("§e此命令只允许玩家使用");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias,String[] args) {
        return null;
    }
}

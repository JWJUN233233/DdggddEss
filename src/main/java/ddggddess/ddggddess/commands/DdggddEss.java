package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.Thread.restart;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class DdggddEss implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender,Command command, String label, String[] args) {
        if (Objects.equals(args[0], "about")) {
            sender.sendMessage("§e帮助信息:");
            sender.sendMessage("§e作者：Ddggdd135");
            sender.sendMessage("§e版本：1.1");
        }

        else if (Objects.equals(args[0], "restart") & args.length == 1) {
            JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(ddggddess.ddggddess.DdggddEss.class);
            int time = config.getConfig().getInt("restart_time");
            Collection<? extends Player> Players = Bukkit.getOnlinePlayers();
            for (Player player : Players) {
                player.sendTitle("§c服务器将在§r" + String.valueOf(time) + "§c分钟后§l重启","",20,120,70);
            }
            restart restart = new restart();
            restart.start((long) time,sender);

        }
        else if (Objects.equals(args[0], "restart") & args.length == 3 & Objects.equals(args[1], "config")) {
            JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(ddggddess.ddggddess.DdggddEss.class);
            config.getConfig().set("restart_time",Integer.valueOf(args[2]));
            sender.sendMessage("§e成功设置重启时间为§r" + String.valueOf(config.getConfig().getInt("restart_time")) + "分钟");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender,Command command,String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1){
            tab.add("about");
            tab.add("restart");
            return tab;
        }
        else if (args.length == 2 & Objects.equals(args[0], "restart")){
            tab.add("config");
            return tab;
        }
        else if (args.length == 3 & Objects.equals(args[0], "restart")){
            tab.add("1");
            return tab;
        }
        else{
            return tab;
        }
    }
}

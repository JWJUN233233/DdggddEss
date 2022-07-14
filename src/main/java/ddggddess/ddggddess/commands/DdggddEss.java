package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.Thread.restart;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class DdggddEss implements CommandExecutor, TabCompleter {
    public static String LastCommand = "";
    public static List<String> CommandList = new ArrayList<>();
    public static Map<String,ddggddess.ddggddess.commands.DdggddEssCommand.Command> ExecutorMap = new HashMap<>();
    public static List<String> getCommandList() {
        return CommandList;
    }
    public static void AddCommand(String CommandName){
        CommandList.add(CommandName);
    }
    public static void SetCommandExecutor(String CommandName, ddggddess.ddggddess.commands.DdggddEssCommand.Command Executor){
        ExecutorMap.put(CommandName,Executor);
    }
    @Override
    public boolean onCommand(CommandSender sender,Command command, String label, String[] args) {
        //System.out.println(args[0]);
        //System.out.println(CommandList.contains(args[0]));
        //System.out.println(CommandList);
        //System.out.println(LastCommand);
        if (Objects.equals(args[0], "about")) {
            sender.sendMessage("§e帮助信息:");
            sender.sendMessage("§e作者：Ddggdd135");
            sender.sendMessage("§e版本：1.7.1 - Debug");
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
            sender.sendMessage("§e成功设置重启时间为§r" + config.getConfig().getInt("restart_time") + "分钟");
            new restart().start((long) config.getConfig().getInt("restart_time"),sender);
        }
        else if(CommandList.contains(args[0])){
            String commandOut = "";
            for(int i = 0;i < args.length;i++){
                commandOut += args[i] + " ";
            }
            Bukkit.dispatchCommand(sender,commandOut);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender,Command command,String alias, String[] args) {
        LastCommand = alias;
        List<String> tab = new ArrayList<>();
        if (args.length == 1){
            tab.add("about");
            tab.add("restart");
            tab.addAll(CommandList);
            return tab;
        }
        else if (args.length == 2 & args[0].equalsIgnoreCase("restart")){
            tab.add("config");
            return tab;
        }
        else if (args.length == 3 & args[0].equalsIgnoreCase("restart")){
            tab.add("1");
            return tab;
        }
        else if(CommandList.contains(args[0])){
                    List<String> argTmp = new ArrayList<>(Arrays.asList(args));argTmp.remove(1);
                    return ExecutorMap.get(args[0]).TabCompleter.onTabComplete(sender, command, args[0], argTmp.toArray(new String[argTmp.size()]));
        }
        return tab;
    }
}

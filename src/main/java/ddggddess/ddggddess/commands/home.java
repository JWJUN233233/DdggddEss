package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.DdggddEss;
import ddggddess.ddggddess.homegui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class home implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        homegui.gui(sender, args);
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if(args.length == 1){
            JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
            List<String> homes =  config.getConfig().getStringList("home");
            for(int i = 0;i<homes.size()/6;i++){
                if(Objects.equals(homes.get(i * 6), sender.getName())){
                    tab.add(homes.get(i * 6 + 5));
                }
            }
        }
        return tab;
    }
}

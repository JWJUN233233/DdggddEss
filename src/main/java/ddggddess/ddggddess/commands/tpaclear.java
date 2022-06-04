package ddggddess.ddggddess.commands;

import ddggddess.ddggddess.other.tpask;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

import static ddggddess.ddggddess.commands.DdggddEss.*;
import static org.bukkit.plugin.java.JavaPlugin.getProvidingPlugin;

public class tpaclear implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        tpask.tpclear();
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias,String[] args) {
        return null;
    }
}

package ddggddess.ddggddess.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class command implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias,String[] args) {
        return null;
    }
}

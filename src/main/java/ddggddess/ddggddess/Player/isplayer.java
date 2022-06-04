package ddggddess.ddggddess.Player;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

public class isplayer {
    public static boolean IsOp(Player player){
        for (OfflinePlayer operator : Bukkit.getOperators()) {
            if(Objects.equals(operator.getName(), player.getName())){
                return true;
            }
        }
        return false;
    }
    public static boolean IsOp(String player){
        for (OfflinePlayer operator : Bukkit.getOperators()) {
            if(Objects.equals(operator.getName(), player)){
                return true;
            }
        }
        return false;
    }
    public static boolean IsHavePlayer(String Player) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String Name = player.getName();
            if (Name.equals(Player)) {
                return true;
            }
        }
        return false;
    }
    public static boolean IsHavePlayer(Player Player) {
        String Name = Player.getName();
        for (Player player : Bukkit.getOnlinePlayers()) {
            String Name1 = player.getName();
            if (Name1.equals(Name)) {
                return true;
            }
        }
        return false;
    }
    public static boolean IsHavePlayerDisplayname(String Displayname) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String Name = player.getDisplayName();
            if (Name.equals(player.getDisplayName())) {
                return true;
            }
        }
        return false;
    }
    public static boolean IsHavePlayerDisplayname(Player Player) {
        String Name = Player.getName();
        for (Player player : Bukkit.getOnlinePlayers()) {
            String Name1 = player.getName();
            if (Name1.equals(Name)) {
                 return true;
            }
        }
        return false;
    }
}
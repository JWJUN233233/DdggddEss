package ddggddess.ddggddess.other;

import com.Zrips.CMI.Modules.Placeholders.PlaceholderAPIHook;
import ddggddess.ddggddess.DdggddEss;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public class DdggddessPapi extends PlaceholderExpansion {

    @Override
    public String getAuthor() {
        return "Ddggdd135";
    }

    @Override
    public String getIdentifier() {
        return "DdggddEss";
    }

    @Override
    public String getVersion() {
        return "1.7.1 - Debug";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("chatnickname")) {
            JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
            String ret = "&a玩家";
            List<String> namelist = config.getConfig().getStringList("chatnickname");
            for (int i = 0; i < namelist.size() / 2; i++) {
                if (Objects.equals(namelist.get(i * 2), player.getName())) {
                    ret = namelist.get(i * 2 + 1);
                    break;
                }
            }
            return ret;
        }
        else if(params.equalsIgnoreCase("displayname")){
            return ((Player)player).getDisplayName();
        }
        else if(params.equalsIgnoreCase("id")){
            return ((Player)player).getName();
        }
        if(params.equalsIgnoreCase("x")){
            return String.valueOf(((Player)player).getLocation().getX());
        }
        if(params.equalsIgnoreCase("y")){
            return String.valueOf(((Player)player).getLocation().getY());
        }
        if(params.equalsIgnoreCase("z")){
            return String.valueOf(((Player)player).getLocation().getZ());
        }
        if(params.equalsIgnoreCase("RGB")){
            return DdggddEss.rgbColor.getHexColor();
        }
        if(params.split(":").length == 2){
            String[] paramsList = params.split(":");
            Player player1 = Bukkit.getPlayer(paramsList[0]);
            return PlaceholderAPI.setPlaceholders(player1,"%" + this.getIdentifier() + "_" + paramsList[1] + "%");
        }
        if(params.split("-").length == 2){
            String[] paramsList = params.split("-");
            Player player1 = Bukkit.getPlayer(paramsList[0]);
            return PlaceholderAPI.setPlaceholders(player1,"%" + paramsList[1].replace("![]","_") + "%");
        }
        return null; // Placeholder is unknown by the Expansion
    }
}
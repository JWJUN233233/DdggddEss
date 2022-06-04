package ddggddess.ddggddess.other;

import ddggddess.ddggddess.DdggddEss;
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
        return "${project.version}";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("chatnickname")) {
            JavaPlugin config = ddggddess.ddggddess.DdggddEss.getProvidingPlugin(DdggddEss.class);
            String ret = "&a玩家";
            List<String> namelist = config.getConfig().getStringList("champion");
            for (int i = 0; i < namelist.size() / 2; i++) {
                if (Objects.equals(namelist.get(i * 2), player.getName())) {
                    ret = namelist.get(i * 2 + 1);
                    break;
                }
            }
            return ret;
        }
        if(params.equalsIgnoreCase("displayname")){
            return ((Player)player).getDisplayName();
        }
        return null; // Placeholder is unknown by the Expansion
    }
}
package ddggddess.ddggddess.event;

import ddggddess.ddggddess.DdggddEss;
import ddggddess.ddggddess.other.NameTranslate;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;
public class chat implements Listener {
    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        try {
            JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
            List<String> chatnickname1 = config.getConfig().getStringList("chatnickname");
            String chatnickname = "§a玩家§r";
            for (int i = 0; i < chatnickname1.size() / 2; i++) {
                if (Objects.equals(chatnickname1.get(i * 2), event.getPlayer().getName())) {
                    chatnickname = chatnickname1.get(i * 2 + 1);
                }
            }
            List<String> ChatColors = config.getConfig().getStringList("chatcolor");
            String color1 = "";
            String color2 = "";
            for (int i = 0; i < ChatColors.size() / 3; i++) {
                if (Objects.equals(ChatColors.get(i * 3), event.getPlayer().getName())) {
                    color1 = ChatColors.get(i * 3 + 1);
                    color2 = ChatColors.get(i * 3 + 2);
                }
            }
            String text = color1 + event.getMessage() + color2;
            text = NameTranslate.Translate(text, event.getPlayer());
            String newchampionstr = "§r" + NameTranslate.Translate(chatnickname, event.getPlayer());
            String newname = NameTranslate.Translate("%DdggddEss_displayname%", event.getPlayer());
            event.setFormat("§7[" + newchampionstr + "§7]§r " + newname + " §7>>§r " + text);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}

package ddggddess.ddggddess.event;

import ddggddess.ddggddess.DdggddEss;
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
        String name = event.getPlayer().getDisplayName();
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        List<String> champion = config.getConfig().getStringList("champion");
        String championstr = "§a玩家§r";
        //if(event.getMessage().contains("[item]")){
        //    ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        //    TextComponent text = new TextComponent();
        //    text.setText(item.getItemMeta().getDisplayName());
        //}
        for (int i = 0; i < champion.size() / 2; i++) {
            if (Objects.equals(champion.get(i * 2), event.getPlayer().getName())) {
                championstr = champion.get(i * 2 + 1);
            }
        }
        List<String> chatcolors = config.getConfig().getStringList("chatcolor");
        String color1 = "";
        String color2 = "";
        for (int i = 0; i < chatcolors.size() / 3; i++) {
            if (Objects.equals(chatcolors.get(i * 3), event.getPlayer().getName())) {
                color1 = chatcolors.get(i * 3 + 1);
                color2 = chatcolors.get(i * 3 + 2);
            }
        }
        String text = color1 + event.getMessage() + color2;
        text = PlaceholderAPI.setPlaceholders(event.getPlayer(), text);
        String newstr = CMIChatColor.translate(text);
        String newchampionstr = "§r" + CMIChatColor.translate(championstr);
        String newname = CMIChatColor.translate(name);
        event.setFormat("§7[" + newchampionstr + "§7] " + newname + " §7>>§r " + newstr);
        //Bukkit.broadcastMessage("§7[" + championstr +  "§7] " + name + " §7>>§r " + event.getMessage());
    }
}

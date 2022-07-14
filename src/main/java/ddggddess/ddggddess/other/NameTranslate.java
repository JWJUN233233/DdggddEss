package ddggddess.ddggddess.other;

import ddggddess.ddggddess.event.CMIChatColor;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NameTranslate {
    public static ItemMeta Translate(ItemMeta itemMeta){
        itemMeta.setDisplayName(Translate(itemMeta.getDisplayName()));
        return itemMeta;
        }
    public static String Translate(String s, Player p){
        String ret =  PlaceholderAPI.setPlaceholders(p,s);
        ret = CMIChatColor.translate(ret);
        ret = ret.replace("\\k"," ");
        return ret;
    }
    public static String Translate(String s){
        String ret = CMIChatColor.translate(s);
        ret = ret.replace("\\k"," ");
        return ret;
    }
}


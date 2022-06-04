package ddggddess.ddggddess.event;
import ddggddess.ddggddess.*;
import ddggddess.ddggddess.other.NameTranslate;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.*;

public class zjh implements Listener {
    @EventHandler
    public void onPrepareAnvilEvent(PrepareAnvilEvent e){
        ItemStack item =  e.getResult();
        ItemMeta itemMeta = item.getItemMeta();
        assert itemMeta != null;
        itemMeta = NameTranslate.Translate(itemMeta);
        item.setItemMeta(itemMeta);
        e.setResult(item);

    }
}
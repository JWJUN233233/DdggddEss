package ddggddess.ddggddess.Thread;

import ddggddess.ddggddess.other.NameTranslate;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class DLoreUpdata implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object[] players = Bukkit.getOnlinePlayers().toArray();
            for (Object player : players) {
                Inventory inventory = ((Player) player).getInventory();
                for (int j = 0; j < 36; j++) {
                    ItemStack item = inventory.getItem(j);
                    if (item == null) {
                        continue;
                    }
                    NBTItem nbti = new NBTItem(item);
                    if (nbti.hasKey("UseDlore")) {
                        List<String> lore = new ArrayList<>();
                        int c = 1;
                        while (true) {
                            if (nbti.hasKey("Dlore" + c)) {
                                lore.add(NameTranslate.Translate(nbti.getString("Dlore" + c), ((Player) player)));
                            } else {
                                break;
                            }
                            c++;
                        }
                        ItemMeta itemMeta = item.getItemMeta();
                        itemMeta.setLore(lore);
                        item.setItemMeta(itemMeta);
                        inventory.setItem(j,item);
                    }
                }
            }
        }
    }
    public void start(){
        Thread t1 = new Thread(this);
        t1.start();
    }
}

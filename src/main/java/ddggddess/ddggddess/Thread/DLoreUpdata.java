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
    public Thread t1 = new Thread(this);
    public boolean isStop = false;
    @Override
    public void run() {
        while (!isStop){
        while (true){
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
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
                                lore.add(NameTranslate.Translate(TranslateNBT(nbti , nbti.getString("Dlore" + c)), ((Player) player)));
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
                    if(nbti.hasKey("DName")){
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(NameTranslate.Translate(TranslateNBT(nbti,nbti.getString("DName")),(Player)player));
                        item.setItemMeta(meta);
                        ((Player) player).getInventory().setItem(j,item);
                    }
                }
            }
        }
            catch (Exception ignored){

            }
        }
        }
    }
    public void start(){
        t1.start();
    }
    public void stop(){
        this.isStop = true;
    }
    private String TranslateNBT(NBTItem NBTI,String s){
        Set<String> NBTKeys = NBTI.getKeys();
        String tmp = s;
        for (String Key : NBTKeys) {
            tmp = tmp.replace("!NBT:" + Key + "!", NBTI.getString(Key));
        }
        return tmp;
    }
}

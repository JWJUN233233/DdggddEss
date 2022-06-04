package ddggddess.ddggddess.event;


import ddggddess.ddggddess.Thread.t1;
import ddggddess.ddggddess.sava;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Objects;

import static ddggddess.ddggddess.DdggddEss.savas;

public class damage implements Listener {
    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player){
            for (ddggddess.ddggddess.sava sava : savas) {
                if ((Objects.equals(sava.player, e.getDamager().getName()))) {
                    sava.damage_time = 0;
                }
            }
            t1 bar = new t1();
            savas.add(new sava());
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            bar.start(e,savas.size() - 1);
        }
    }
}

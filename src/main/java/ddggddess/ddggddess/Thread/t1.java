package ddggddess.ddggddess.Thread;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import static ddggddess.ddggddess.DdggddEss.savas;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class t1 implements Runnable {
    public EntityDamageByEntityEvent e;
    public int id;
    public t1(){

    }
    @Override
    public void run() {
        Player player = (Player) e.getDamager();
        savas.get(id).damage_time = 2500;
        savas.get(id).player = player.getName();
        double EventDamage = e.getDamage();
        double EntityDef = ((LivingEntity)e.getEntity()).getAttribute(Attribute.GENERIC_ARMOR).getValue();
        double EntityTOU = ((LivingEntity)e.getEntity()).getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue();
        double Player_RealAttack = (EventDamage * (1 - min(20, max(EntityDef / 5, EntityDef - EventDamage / (2 + (EntityTOU / 4))) / 25)));
        BossBar gui =  Bukkit.createBossBar(e.getEntity().getName() + "  " +  String.valueOf(((LivingEntity)e.getEntity()).getHealth()) + "/" + String.valueOf(((LivingEntity)e.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + "     -" + String.valueOf(Player_RealAttack)), BarColor.GREEN, BarStyle.SOLID);
        gui.setProgress((((Damageable)e.getEntity()).getHealth())/((LivingEntity)e.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        gui.addPlayer(player);
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            savas.get(id).damage_time -= 10;
            if(savas.get(id).damage_time <= 0){
                gui.removeAll();
                break;
            }
        }
    }
    public void start(EntityDamageByEntityEvent e,int id){
        this.id = id;
        this.e = e;
        Thread t1 = new Thread(this);
        t1.start();
    }
}

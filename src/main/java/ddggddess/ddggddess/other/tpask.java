package ddggddess.ddggddess.other;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class tpask {
    public static List<tpask> tpasks = new ArrayList<>();
    public enum tptype{
        tpa,
        tpahere;
    }
    public Player player;
    public Player tp_to_player;
    public static tptype tptype;
    public long time;
    public static long timeMax = 60;
    public static void tpclear(){
        tpasks = new ArrayList<>();
    }
    public void accept(){
        if ((System.currentTimeMillis() - time) > timeMax){
            return;
        }
        if (tptype == tpask.tptype.tpahere) {
            tp_to_player.sendMessage(player.getDisplayName() + "§e同意了你的请求");
            player.teleport(tp_to_player);
        }
        else if(tptype == tpask.tptype.tpa){
            player.sendMessage(tp_to_player.getDisplayName() + "§e同意了你的请求");
            player.teleport(tp_to_player);
        }
    }
    public static void accept(Player player){
        for(int i = 0; i<tpasks.size(); i++){
            if(tpasks.get(i).player.getName() == player.getName() & System.currentTimeMillis() - tpasks.get(i).time > timeMax){
                tpasks.get(i).accept();
                tpasks.remove(i);
                return;
            }
        }
        for(int i = 0; i<tpasks.size(); i++){
            if(tpasks.get(i).tp_to_player.getName() == player.getName() & System.currentTimeMillis() - tpasks.get(i).time > timeMax){
                tpasks.get(i).accept();
                tpasks.remove(i);
                return;
            }
        }
        player.sendMessage("§e没有待同意的请求");
    }
    public static void createAsk(Player player, Player tp_to_player, tptype tptype){
        for(int i = 0; i<tpasks.size(); i++){
            if(tpasks.get(i).player.getName() == player.getName() & System.currentTimeMillis() - tpasks.get(i).time < timeMax){
                player.sendMessage("§e" + timeMax + "后才可发送请求");
                return;
            }
        }
        for(int i = 0; i<tpasks.size(); i++){
            if(tpasks.get(i).tp_to_player.getName() == tp_to_player.getName() & System.currentTimeMillis() - tpasks.get(i).time < timeMax){
                player.sendMessage("§e" + timeMax + "后才可发送请求");
                return;
            }
        }
        if(player.getName() == tp_to_player.getName()){
            switch (tptype){
                case tpa:
                    player.sendMessage("§e你不能传送你自己");
                    return;
                case tpahere:
                    tp_to_player.sendMessage("§e你不能传送你自己");
                    return;
            }
        }
        tpask temp = new tpask();
        temp.player = player;
        temp.tp_to_player = tp_to_player;
        tpask.tptype = tptype;
        temp.time = System.currentTimeMillis();
        tpasks.add(temp);
        if (tptype == tpask.tptype.tpa) {
            player.sendMessage("§e传送请求发送到§r" + tp_to_player.getDisplayName());
            System.out.println(player.getName() + "给" + tp_to_player.getDisplayName() + "发送了传送请求");
            tp_to_player.sendMessage(player.getDisplayName() + "§e请求传送到你身边，输入/tpaccept同意请求");
        }
        else if (tptype == tpask.tptype.tpahere) {
            tp_to_player.sendMessage("§e传送请求发送到§r" + player.getDisplayName());
            System.out.println(tp_to_player.getName() + "给" + player.getDisplayName() + "发送了被传送请求");
            player.sendMessage(tp_to_player.getDisplayName() + "§e请求你传送他们，输入/tpaccept同意请求");
        }
    }
}

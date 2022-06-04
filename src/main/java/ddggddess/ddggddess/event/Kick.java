package ddggddess.ddggddess.event;

import ddggddess.ddggddess.Player.isplayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Kick implements Listener {
    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event){
        String[] args = event.getMessage().split(" ");
        List<String> arg = new ArrayList<>();
        for (int i = 1;i<args.length;i++) {
            if (!(Objects.equals(args[i], ""))) {
                arg.add(args[i]);
            }
        }
        if(Objects.equals(event.getMessage().split(" ")[0], "/kick")){
            if(isplayer.IsOp(args[1])){
                event.setCancelled(true);
                event.getPlayer().sendMessage("§c你不可以踢出管理,请在控制台操作");
        }
        }
    }
}

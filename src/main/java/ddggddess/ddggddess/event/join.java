package ddggddess.ddggddess.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class join implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        event.setJoinMessage(null);
        Bukkit.broadcastMessage("§7[§a+§7]§r" + CMIChatColor.translate(event.getPlayer().getDisplayName()));
        event.getPlayer().sendMessage("[§c公告§r]目前服务器插件已更新，需要注册和登录，输入/l来登录，/register注册");
    }
}

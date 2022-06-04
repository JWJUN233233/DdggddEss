package ddggddess.ddggddess.Thread;

import com.comphenix.protocol.PacketType;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class restart implements Runnable {
    public Long time;
    public Thread t;
    public CommandSender sender;
    @Override
    public void run() {
        try {
            Thread.sleep(60 * time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/kick @a §c§l服务器正在重启\n§c§l请稍后连接");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/restart");
    }

    public void start(Long time, CommandSender sender) {
        this.sender = sender;
        this.time = time;
        if (t == null) {
            t = new Thread(this, "restart");
            t.start();
        }
    }
}

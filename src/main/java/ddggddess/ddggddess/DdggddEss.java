package ddggddess.ddggddess;
import ddggddess.ddggddess.Thread.DLoreUpdata;
import ddggddess.ddggddess.commands.*;
import ddggddess.ddggddess.event.*;
import ddggddess.ddggddess.other.DLore;
import ddggddess.ddggddess.other.DdggddessPapi;
import de.tr7zw.nbtapi.plugin.NBTAPI;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;

public final class DdggddEss extends JavaPlugin {
    public static List<sava> savas = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        //注册命令
        getCommand("Dlore").setExecutor(new DLore());
        getCommand("chatcolor").setExecutor(new chatcolor());
        getCommand("sethome").setExecutor(new sethome());
        getCommand("home").setExecutor(new home());
        getCommand("suicide").setExecutor(new suicide());
        getCommand("back").setExecutor(new back());
        getCommand("tpaclear").setExecutor(new tpaclear());
        getCommand("chatnickname").setExecutor(new chatnickname());
        getCommand("unban").setExecutor(new unban());
        getCommand("heal").setExecutor(new heal());
        getCommand("feed").setExecutor(new feed());
        getCommand("lockplayer").setExecutor(new lockplayer());
        getCommand("tpahere").setExecutor(new tpahere());
        getCommand("invsee").setExecutor(new invsee());
        getCommand("DisplayName").setExecutor(new DisplayName());
        getCommand("gm").setExecutor(new gm());
        getCommand("msg").setExecutor(new msg());
        getCommand("tpa").setExecutor(new tpa());
        getCommand("tpaccept").setExecutor(new tpaccept());
        getCommand("DdggddEss").setExecutor(new ddggddess.ddggddess.commands.DdggddEss());
        //注册事件
        getServer().getPluginManager().registerEvents(new HomesGui(),this);
        getServer().getPluginManager().registerEvents(new zjh(),this);
        getServer().getPluginManager().registerEvents(new damage(),this);
        getServer().getPluginManager().registerEvents(new Kick(),this);
        getServer().getPluginManager().registerEvents(new lock(),this);
        //getServer().getPluginManager().registerEvents(new DisplayNameEvent(),this);
        getServer().getPluginManager().registerEvents(new invseeevent(),this);
        getServer().getPluginManager().registerEvents(new chat(),this);
        getServer().getPluginManager().registerEvents(new join(),this);
        getServer().getPluginManager().registerEvents(new exit(),this);
        getServer().getPluginManager().registerEvents(new backevent(),this);
        getServer().getPluginManager().registerEvents(new MoveName(),this);
        //注册papi变量
        new DdggddessPapi().register();
        //初始化配置
        JavaPlugin config = DdggddEss.getProvidingPlugin(DdggddEss.class);
        config.getConfig().set("invsee",null);
        config.getConfig().set("home_open",null);
        saveDefaultConfig();
         new DLoreUpdata().start();
        System.out.println("DdggddEss已加载");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
        System.out.println("DdggddEss已卸载");
    }

}

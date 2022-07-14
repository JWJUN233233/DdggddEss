package ddggddess.ddggddess;

import ddggddess.ddggddess.Thread.DLoreUpdata;
import ddggddess.ddggddess.commands.*;
import ddggddess.ddggddess.commands.DdggddEssCommand.Command;
import ddggddess.ddggddess.event.*;
import ddggddess.ddggddess.commands.DLore;
import ddggddess.ddggddess.other.DdggddessPapi;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;
import ddggddess.ddggddess.Thread.*;
public final class DdggddEss extends JavaPlugin {
    public static List<sava> savas = new ArrayList<>();
    public static DLoreUpdata DLoreUpdata = new DLoreUpdata();
    public static RGBColor rgbColor = new RGBColor();
    public static void RegisterDdggddEssCommand(CommandExecutor commandExecutor,String CommandName){
        ddggddess.ddggddess.commands.DdggddEssCommand.Command command = new Command();
        command.CommandExecutor = commandExecutor;
        command.TabCompleter = (TabCompleter) commandExecutor;
        ddggddess.ddggddess.commands.DdggddEss.AddCommand(CommandName);
        ddggddess.ddggddess.commands.DdggddEss.SetCommandExecutor(CommandName,command);
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        //注册命令
        getCommand("NBT").setExecutor(new NBT());
        getCommand("DName").setExecutor(new DName());
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
        //DdggddEssCommand
        RegisterDdggddEssCommand(new NBT(),"NBT");
        RegisterDdggddEssCommand(new DName(),"DLame");
        RegisterDdggddEssCommand(new DLore(),"DLore");
        RegisterDdggddEssCommand(new chatcolor(),"chatcolor");
        RegisterDdggddEssCommand(new sethome(),"sethome");
        RegisterDdggddEssCommand(new home(),"home");
        RegisterDdggddEssCommand(new suicide(),"suicide");
        RegisterDdggddEssCommand(new back(),"back");
        RegisterDdggddEssCommand(new tpaclear(),"tpaclear");
        RegisterDdggddEssCommand(new chatnickname(),"chatnickname");
        RegisterDdggddEssCommand(new unban(),"unban");
        RegisterDdggddEssCommand(new heal(),"heal");
        RegisterDdggddEssCommand(new feed(),"feed");
        RegisterDdggddEssCommand(new lockplayer(),"lockplayer");
        RegisterDdggddEssCommand(new tpahere(),"tpahere");
        RegisterDdggddEssCommand(new invsee(),"invsee");
        RegisterDdggddEssCommand(new DisplayName(),"displayname");
        RegisterDdggddEssCommand(new gm(),"gm");
        RegisterDdggddEssCommand(new msg(),"msg");
        RegisterDdggddEssCommand(new tpa(),"tpa");
        RegisterDdggddEssCommand(new tpaccept(),"tpaccept");
        RegisterDdggddEssCommand(new ddggddess.ddggddess.commands.DdggddEss(),"ddggddess");
        //注册事件
        getServer().getPluginManager().registerEvents(new ddggddess.ddggddess.event.DdggddEss(),this);
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
        DLoreUpdata.start();
        rgbColor.start();
        System.out.println("DdggddEss已加载");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
        DLoreUpdata.stop();
        rgbColor.stop();
        System.out.println("DdggddEss已卸载");
    }
}

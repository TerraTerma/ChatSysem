package me.JustMaffie.TerraTerma.TTChatSystem;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import TTCore.Savers.Saver;
import me.JustMaffie.TerraTerma.TTChatSystem.Listeners.ChatListener;

public class Main extends JavaPlugin {

	private static String name;
	private static String version;

	private Logger logger = getLogger();

	public void onEnable(){

		Saver saver = new Saver(new File("plugins/TTChatSystem/ChatConfig.yml"));
		saver.set("&5@", "Mention.AFK");
		saver.set("&e@", "Mention.Format");
		saver.save();
		
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);

		Bukkit.getConsoleSender().sendMessage("&a" + name + " " + version + " by JustMaffie is now Enabeld");
	}
	
	@Override
	public void onDisable () {
		logger.info(name + " " + version + " disabled.");
	}

}
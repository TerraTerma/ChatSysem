package me.JustMaffie.TerraTerma.TTChatSystem;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import TTCore.Mech.DataHandler;
import TTCore.Savers.Saver;
import me.JustMaffie.TerraTerma.TTChatSystem.Commands.SetFormatCMD;
import me.JustMaffie.TerraTerma.TTChatSystem.Listeners.ChatListener;
import me.JustMaffie.TerraTerma.TTChatSystem.Mechs.MessageFormatData;

public class Main extends JavaPlugin {

	private String name = getDescription().getName();
	private String version = getDescription().getVersion();
	private static Main PLUGIN;

	private Logger logger = getLogger();

	public void onEnable(){

		PLUGIN = this;
		Saver saver = new Saver(new File("plugins/TTChatSystem/ChatConfig.yml"));
		saver.set("&5@", "Mention.AFK");
		saver.set("&e@", "Mention.Format");
		saver.save();
		
		DataHandler.MECHS.add(MessageFormatData.class);
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		getCommand("setformat").setExecutor(new SetFormatCMD());

		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + name + " " + version + " by JustMaffie is now Enabeld");
	}
	
	@Override
	public void onDisable () {
		logger.info(name + " " + version + " disabled.");
	}

	public static Plugin getPlugin() {
		return PLUGIN;
	}

}
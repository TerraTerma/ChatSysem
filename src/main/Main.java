package main;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import games.ChatGameQueue;
import games.GameUtilities;
import games.ReactionGame;

public class Main extends JavaPlugin {

	private static String name;
	private static String version;
	private static Server server;
	private static PluginManager manager;
	
	private Logger logger = getLogger();
	
	@Override
	public void onEnable () {		
		name = getName();
		version = getDescription().getVersion();
		server = getServer();
		manager = server.getPluginManager();
		
		/*
		 * Create and load the configuration.
		 */
		ChatConfig.load(getDataFolder() + "/config.yml");
		
		/*
		 * Chat games
		 */
		GameUtilities.load(this);

		ReactionGame reaction = new ReactionGame ();
		
		manager.registerEvents(reaction, this);
		
		ChatGameQueue gameQueue = new ChatGameQueue();
		gameQueue.addGame(reaction);
		gameQueue.start();
		
		/*
		 * Attempt to load other necessary plugins.
		 */
		Hooker hooker = new Hooker(getServer());
		
		if (hooker.attemptHook(HookerPlugin.MULTIVERSE)) {
			logger.info("Found Multiverse!");
		}
		
		if(hooker.attemptHook(HookerPlugin.PERMISSIONS)) {
			logger.info("Found Permissions!");
		}
		
		if(hooker.attemptHook(HookerPlugin.ESSENTIALS)) {
			logger.info("Found Essentials!");
		}
		
		/*
		 * Register events.
		 */
		manager.registerEvents(new MentionEvent(), this);
		manager.registerEvents(new ChatFormatter(), this);
		
		logger.info(name + " " + version + " enabled.");
	}
	
	@Override
	public void onDisable () {
		
		logger.info(name + " " + version + " disabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("chatsystem") || label.equalsIgnoreCase("cs")) {
			sender.sendMessage(ChatUtilities.colorText("&e" + name + " &d" + version));
			return true;
		}
		
		return false;
	}
	
	/**
	 * Get the name of the plugin.
	 * @return
	 */
	public static String getPluginName () {
		return name;
	}
	
	/**
	 * Get current version of the plugin.
	 * @return
	 */
	public static String getPluginVersion () {
		return version;
	}
	
}

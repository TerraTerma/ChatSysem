package main;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import chatgame.ChatGameQueue;
import chatgame.GameUtilities;
import chatgame.games.ReactionGame;

public class Main extends JavaPlugin {

	private static String name;
	private static String version;
	private static Server server;
	private static PluginManager manager;
	
	private Logger logger = getLogger();
	
	private ChatGameQueue chatGameQueue;
	
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
		
		chatGameQueue = new ChatGameQueue();
		chatGameQueue.addGame(reaction);
		chatGameQueue.start();
		
		/*
		 * Attempt to load other necessary plugins.
		 */
		Hooker hooker = new Hooker(getServer());
		
		if (hooker.attemptHook(HookerPlugin.MULTIVERSE)
			&& hooker.attemptHook(HookerPlugin.PERMISSIONS)
			&& hooker.attemptHook(HookerPlugin.ESSENTIALS));
		else setEnabled(false);
		
		/*
		 * Register events.
		 */
		manager.registerEvents(new MentionEvent(), this);
		manager.registerEvents(new ChatEvent(), this);
		
		logger.info(name + " " + version + " enabled.");
	}
	
	@Override
	public void onDisable () {
		
		logger.info(name + " " + version + " disabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("chatsystem")) {
			sender.sendMessage(name + " " + version);
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

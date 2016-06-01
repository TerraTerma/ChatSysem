package main;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import chatgame.ChatGameQueue;
import chatgame.ChatGameChatListener;
import chatgame.ChatGameHelper;
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
		
		ChatConfig.load(getDataFolder() + "/config.yml");
		Hooker.load (server);
		ChatGameHelper.load(this);
		
		ReactionGame reaction = new ReactionGame();
		
		chatGameQueue = new ChatGameQueue();
		chatGameQueue.addGame(reaction);
		chatGameQueue.startQueue();
		
		ChatGameChatListener chatGameChatListener = new ChatGameChatListener();
		chatGameChatListener.listenOn(reaction);
		
		manager.registerEvents(new MentionEvent(), this);
		manager.registerEvents(new ChatEvent(), this);
		manager.registerEvents(chatGameChatListener, this);
		
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

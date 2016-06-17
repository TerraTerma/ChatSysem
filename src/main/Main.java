package main;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import chatgame.ChatGameQueue;
import chatgame.ChatGameRegistry;
import chatgame.event.handler.ChatGameHandler;
import chatgame.games.HangmanGame;
import chatgame.games.LetterGame;
import chatgame.games.ReactionGame;
import command.CommandHandler;
import event.ChatEvent;
import event.MentionEvent;
import utilities.ChatGameHelper;

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
		
		new ChatConfig(getDataFolder() + "/config.yml");
		new Hooker(server);
		new ChatGameHelper(this);
		
		ReactionGame reactionGame = new ReactionGame();
		LetterGame letterGame = new LetterGame();
		HangmanGame hangmanGame = new HangmanGame();
		
		new ChatGameRegistry(this);
		ChatGameRegistry.registerGame(reactionGame);
		ChatGameRegistry.registerGame(letterGame);
		ChatGameRegistry.registerGame(hangmanGame);
		
		ChatGameQueue chatGameQueue = new ChatGameQueue();
		ChatGameRegistry.fillQueue(chatGameQueue);
		chatGameQueue.startQueue();
		
		ChatGameEvents events = new ChatGameEvents();
		ChatGameHandler.addListener(events);
		
		manager.registerEvents(new MentionEvent(), this);
		manager.registerEvents(new ChatEvent(), this);
		
		CommandHandler commandHandler = new CommandHandler();
		getCommand("cgreward").setExecutor(commandHandler);
		
		logger.info(name + " " + version + " enabled.");
	}
	
	@Override
	public void onDisable () {
		
		logger.info(name + " " + version + " disabled.");
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

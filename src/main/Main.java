package main;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import chatgame.ChatGameQueue;
import chatgame.ChatGameRegistry;
import chatgame.games.HangmanGame;
import chatgame.games.LetterGame;
import chatgame.games.ReactionGame;
import command.CommandHandler;
import event.BreakEvent;
import event.ChatEvent;
import event.ChatGameWinEventHandler;
import event.MentionEvent;
import event.handlers.ChatGameWinHandler;
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
		
		ChatGameRegistry chatGameRegistry = new ChatGameRegistry(this);
		chatGameRegistry.registerGame(new ReactionGame());
		chatGameRegistry.registerGame(new LetterGame());
		chatGameRegistry.registerGame(new HangmanGame());

		ChatGameQueue chatGameQueue = new ChatGameQueue();
		chatGameRegistry.fillQueue(chatGameQueue);
		chatGameQueue.startQueue();
		
		manager.registerEvents(new MentionEvent(), this);
		manager.registerEvents(new ChatEvent(), this);
		manager.registerEvents(new BreakEvent(), this);
		
		new ChatGameWinHandler();
		ChatGameWinHandler.addListener(new ChatGameWinEventHandler());
		
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

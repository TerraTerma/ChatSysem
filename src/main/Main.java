package main;
import java.util.logging.Logger;

import chatgame.hangman.HangmanGame;
import chatgame.reaction.ReactionGame;
import command.*;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import chatgame.ChatGameQueue;
import chatgame.ChatGameRegistry;
import chatgame.event.ChatGameHandler;
import chatgame.letter.LetterGame;
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
		
		new ChatGameRegistry(this);
		ChatGameRegistry.registerGame(new ReactionGame());
		ChatGameRegistry.registerGame(new LetterGame());
		ChatGameRegistry.registerGame(new HangmanGame());

		ChatGameRegistry.fillQueue();
		ChatGameQueue.startQueue();

		ChatGameEvents events = new ChatGameEvents();
		ChatGameHandler.addListener(events);
		
		manager.registerEvents(new MentionEvent(), this);
		manager.registerEvents(new ChatEvent(), this);

		new CommandRegistry(this);
		CommandRegistry.registerCommand(new InfoCommand(this));
		CommandRegistry.registerCommand(new ForceCommand());
		CommandRegistry.registerCommand(new RewardCommand());
		CommandRegistry.registerCommand(new SkipCommand());
		
		logger.info(name + " " + version + " enabled.");
	}
	
	@Override
	public void onDisable () {
		logger.info(name + " " + version + " disabled.");
	}
	
}

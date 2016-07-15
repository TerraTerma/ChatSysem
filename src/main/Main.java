package main;

import chatgame.ChatGameQueue;
import chatgame.ChatGameRegistry;
import chatgame.event.ChatGameHandler;
import chatgame.game.ReactionGame;
import command.*;
import configuration.ChatConfiguration;
import configuration.ConfigurationRegistry;
import configuration.GroupConfiguration;
import configuration.ReactionGameConfiguration;
import event.ChatEvent;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import utilities.ChatGameHelper;

import java.util.logging.Logger;

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

		new Hooker(server);
		new ChatGameHelper(this);

		ChatConfiguration chatConfiguration = new ChatConfiguration();
		GroupConfiguration groupConfiguration = new GroupConfiguration();

		new ConfigurationRegistry();
		ConfigurationRegistry.registerConfiguration(chatConfiguration);
		ConfigurationRegistry.registerConfiguration(groupConfiguration);

		new ChatGameRegistry(this);
		ChatGameRegistry.registerGame(new ReactionGame(), new ReactionGameConfiguration());

		ChatGameRegistry.fillQueue();
		ChatGameQueue.reloadGames();
		ChatGameQueue.startQueue();

		ChatGameEvents events = new ChatGameEvents();
		ChatGameHandler.addListener(events);
		
		manager.registerEvents(new ChatEvent(), this);

		ChatSystemCommand[] commands = {
				new InfoCommand(this),
				new ForceCommand(),
				new RewardCommand(),
				new SkipCommand(),
				new ReloadCommand(),
				new EnableCommand(),
				new DisableCommand(),
				new ReactionGameCommand(),
				new GameReloadCommand()
		};

		new CommandRegistry(this);

		for (ChatSystemCommand command : commands)
			CommandRegistry.registerCommand(command);
		
		logger.info(name + " " + version + " enabled.");
	}
	
	@Override
	public void onDisable () {
		logger.info(name + " " + version + " disabled.");
	}
	
}

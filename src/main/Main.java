package main;

import chatgame.ChatGameQueue;
import chatgame.ChatGameRegistry;
import chatgame.event.ChatGameEvents;
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

	private Logger logger = getLogger();

	@Override
	public void onEnable () {
		Server server = getServer();
		PluginManager pluginManager = server.getPluginManager();

		name = getName();
		version = getDescription().getVersion();

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
		
		pluginManager.registerEvents(new ChatEvent(), this);

		ChatSystemCommand[] commands = {
				new InfoCommand(this),
				new ForceCommand(),
				new SkipCommand(),
				new ReloadCommand(),
				new StaffChatCommand(),
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

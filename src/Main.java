import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static String name;
	private static String version;
	
	private Logger logger = getLogger();
	
	@Override
	public void onEnable () {		
		name = getName();
		version = getDescription().getVersion();
		
		/*
		 * Create and load the configuration.
		 */
		ChatConfig chatConfig = new ChatConfig(getDataFolder() + "/config.yml");
		
		ChatFormatter chatFormatter = new ChatFormatter();
		chatFormatter.setFormat(chatConfig.getFormat());
		
		MentionEvent mentionEvent = new MentionEvent();
		mentionEvent.setPrefix(chatConfig.getMentionPrefix());
		
		/*
		 * Attempt to load other necessary plugins.
		 */
		Hooker hooker = new Hooker(getServer());
		
		if (hooker.attemptMultiverseHook()) {
			logger.info("Found Multiverse!");
		}
		
		if(hooker.attemptPermissionsHook()) {
			logger.info("Found Permissions!");
		}
		
		if(hooker.attemptEssentialsHook()) {
			logger.info("Found Essentials!");
		}
		
		/*
		 * Register events.
		 */
		Server server = getServer();
		PluginManager manager = server.getPluginManager();
		
		manager.registerEvents(chatFormatter, this);
		manager.registerEvents(mentionEvent, this);
		
		logger.info(name + " " + version + " enabled.");
	}
	
	@Override
	public void onDisable () {
		logger.info(name + " " + version + " disabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("chatsystem") || label.equalsIgnoreCase("cs")) {
			
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

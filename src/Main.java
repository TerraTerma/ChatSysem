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
		chatConfig.save();
		
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
		Server server = getServer();
		PluginManager manager = server.getPluginManager();
		
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

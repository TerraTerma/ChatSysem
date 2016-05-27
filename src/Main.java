import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private String configPath;
	
	private static String name;
	private static String version;
	
	private Logger logger = getLogger();
	
	@Override
	public void onEnable () {		
		name = getName();
		version = getDescription().getVersion();
		
		configPath = getDataFolder() + "/config.yml";
		
		/*
		 * Create and load the configuration.
		 */
		ChatConfig chatConfig = new ChatConfig(configPath);
		
		ChatFormatter chatFormatter = new ChatFormatter();
		chatFormatter.setFormat(chatConfig.getFormat());
		
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
		getServer().getPluginManager().registerEvents(new ChatFormatter(), this);
		
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
	 * Color a string of text using color codes.
	 * @param text The text to color.
	 * @return String of colored text.
	 */
	public String colorText (String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
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

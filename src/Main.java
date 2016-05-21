import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static final String VERSION = "1.0";
	
	private Logger logger = getLogger();
	
	@Override
	public void onEnable () {

		boolean hasMultiverse = checkMultiverse();
		if (!hasMultiverse) logger.info("Couldn't find multiverse.");
		
		logger.info(getName() + " " + VERSION + " enabled.");
	}
	
	@Override
	public void onDisable () {
		logger.info(getName() + " " + VERSION + " disabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("chatsystem") || label.equalsIgnoreCase("cs")) {
			
		}
		
		return false;
	}
	
	private boolean checkMultiverse () {
		final String name = "Multiverse";
		Server server = getServer();
		PluginManager pluginManager = server.getPluginManager();
		Plugin plugin = pluginManager.getPlugin(name);
		return (plugin != null && plugin.isEnabled());
	}
	
	public String getHelpText () {
		StringBuilder builder = new StringBuilder();
		builder.append(getName() + " " + VERSION);
		
		//TODO finish help
		
		return builder.toString();
	}
	
	public String colorText (String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
}

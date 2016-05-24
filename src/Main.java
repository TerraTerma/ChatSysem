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
	private static Main MAIN;

	@Override
	public void onEnable() {
		MAIN = this;
		name = getName();
		version = getDescription().getVersion();
		configPath = getDataFolder() + "/config.yml";
		/* Create and load the configuration. */
		ChatConfig chatConfig = new ChatConfig(configPath);
		ChatFormatter chatFormatter = new ChatFormatter();
		chatFormatter.setFormat(chatConfig.getFormat());
		/* Attempt to load other necessary plugins. */
		Hooker hooker = new Hooker();
		if (hooker.attemptMultiverseHook()) {
			logger.info("Found Multiverse!");
		}
		if (hooker.attemptPermissionsHook()) {
			logger.info("Found Permissions!");
		}
		if (hooker.attemptEssentialsHook()) {
			logger.info("Found Essentials!");
		}
		/* Register events. */
		getServer().getPluginManager().registerEvents(new ChatFormatter(), this);
		logger.info(name + " " + version + " enabled.");
	}

	@Override
	public void onDisable() {
		logger.info(name + " " + version + " disabled.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("chatsystem") || label.equalsIgnoreCase("cs")) {

		}
		return false;
	}

	public String getHelpText() {
		StringBuilder builder = new StringBuilder();
		builder.append(getName() + " " + version);

		// TODO finish help

		return builder.toString();
	}

	public String colorText(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

	public static String getPluginName() {
		return name;
	}

	public static String getPluginVersion() {
		return version;
	}
	
	public static Main getPlugin(){
		return MAIN;
	}

}

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static final String VERSION = "1.0";
	
	@Override
	public void onEnable () {
		getLogger().info(getName() + " " + VERSION + " enabled.");
	}
	
	@Override
	public void onDisable () {
		getLogger().info(getName() + " " + VERSION + " disabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("chatsystem") || label.equalsIgnoreCase("cs")) {
			
		}
		
		return false;
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

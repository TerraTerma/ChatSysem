import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Hooker {
	
	private PluginManager pluginManager;
	
	public Hooker (Server server) {
		this.pluginManager = server.getPluginManager();
	}
	
	public boolean attemptMultiverseHook () {
		return isPresent("Multiverse");
	}
	
	public boolean attemptPermissionsHook () {
		return isPresent("Permissions");
	}
	
	public boolean attemptEssentialsHook () {
		return isPresent("Essentials");
	}
	
	private boolean isPresent (String pluginName) {
		Plugin plugin = pluginManager.getPlugin("Multiverse");
		if (plugin != null && plugin.isEnabled()) return true;
		else return false;
	}
	
}

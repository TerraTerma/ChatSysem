import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Hooker {

	private PluginManager pluginManager;
	
	/**
	 * Used to check if other plugins are available for instantiation.
	 * @param server
	 */
	public Hooker (Server server) {
		this.pluginManager = server.getPluginManager();
	}
	
	/**
	 * Checks to see of the Multiverse plugin is present on the server.
	 * @return
	 */
	public boolean attemptMultiverseHook () {
		return isPresent("Multiverse");
	}
	
	/**
	 * Checks to see of the Permissions plugin is present on the server.
	 * @return
	 */
	public boolean attemptPermissionsHook () {
		return isPresent("Permissions");
	}
	
	/**
	 * Checks to see of the Essentials plugin is present on the server.
	 * @return
	 */
	public boolean attemptEssentialsHook () {
		return isPresent("Essentials");
	}
	
	private boolean isPresent (String pluginName) {
		Plugin plugin = pluginManager.getPlugin("Multiverse");
		if (plugin != null && plugin.isEnabled()) return true;
		else return false;
	}

}

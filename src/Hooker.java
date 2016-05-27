import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Hooker {

	private PluginManager pluginManager;
	
	private static boolean hasMultiverse;
	private static boolean hasPermissions;
	private static boolean hasEssentials;
	
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
		hasMultiverse = true;
		return isPresent("Multiverse");
	}
	
	/**
	 * Checks to see of the Permissions plugin is present on the server.
	 * @return
	 */
	public boolean attemptPermissionsHook () {
		hasPermissions = true;
		return isPresent("Permissions");
	}
	
	/**
	 * Checks to see of the Essentials plugin is present on the server.
	 * @return
	 */
	public boolean attemptEssentialsHook () {
		hasEssentials = true;
		return isPresent("Essentials");
	}
	
	public static boolean hasMultiverse () {
		return hasMultiverse;
	}
	
	public static boolean hasPermissions () {
		return hasPermissions;
	}
	
	public static boolean hasEssentials () {
		return hasEssentials;
	}
	
	private boolean isPresent (String pluginName) {
		Plugin plugin = pluginManager.getPlugin("Multiverse");
		if (plugin != null && plugin.isEnabled()) return true;
		else return false;
	}

}

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import com.onarandombox.MultiverseCore.MultiverseCore;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Hooker {

	private static PluginManager pluginManager;
	
	/**
	 * Used to check if other plugins are available for instantiation.
	 * @param server
	 */
	public Hooker (Server server) {
		pluginManager = server.getPluginManager();
	}
	
	public boolean attemptHook (HookerPlugin hookerPlugin) {
		return isPresent(hookerPlugin);
	}
	
	public static MultiverseCore getMultiverseCore () {
		return (MultiverseCore) getPlugin (HookerPlugin.MULTIVERSE);
	}
	
	public static PermissionsEx getPermissions () {
		return (PermissionsEx) getPlugin (HookerPlugin.PERMISSIONS);
	}
	
	//TODO add method for getting essentials plugin
	
	private boolean isPresent (HookerPlugin hookerPlugin) {
		Plugin plugin = pluginManager.getPlugin(hookerPlugin.getName());
		if (plugin != null && plugin.isEnabled())  {
			hookerPlugin.setPresent(true);
			return true;
		}
		else return false;
	}
	
	private static Plugin getPlugin (HookerPlugin hookerPlugin) {
		Plugin plugin = pluginManager.getPlugin(hookerPlugin.getName());
		if (plugin != null && plugin.isEnabled()) return plugin;
		else return null;
	}

}

enum HookerPlugin {
	
	MULTIVERSE("Multiverse-Core"),
	PERMISSIONS("PermissionsEx"),
	ESSENTIALS("Essentials");
	
	private String name;
	private boolean present;
	
	HookerPlugin (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isPresent () {
		return present;
	}
	
	public void setPresent (boolean present) {
		this.present = present;
	}
	
}

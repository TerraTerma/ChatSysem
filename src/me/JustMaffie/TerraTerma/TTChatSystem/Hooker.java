package me.JustMaffie.TerraTerma.TTChatSystem;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import com.earth2me.essentials.Essentials;
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
	
	public static MultiverseCore getMultiverseCore () {
		return (MultiverseCore) getPlugin (HookerPlugin.MULTIVERSE);
	}
	
	public static PermissionsEx getPermissions () {
		return (PermissionsEx) getPlugin (HookerPlugin.PERMISSIONS);
	}
	
	public static Essentials getEssentials () {
		return (Essentials) getPlugin (HookerPlugin.ESSENTIALS);
	}
	
	private static Plugin getPlugin (HookerPlugin hookerPlugin) {
		Plugin plugin = pluginManager
				.getPlugin(hookerPlugin.getName());
		
		return plugin;
	}

}

enum HookerPlugin {
	
	MULTIVERSE("Multiverse-Core"),
	PERMISSIONS("PermissionsEx"),
	ESSENTIALS("Essentials");
	
	private String name;
	
	HookerPlugin (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}

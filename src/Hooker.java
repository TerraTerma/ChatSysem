import org.bukkit.plugin.Plugin;

public class Hooker {

	public boolean attemptMultiverseHook() {
		return isPresent("Multiverse");
	}

	public boolean attemptPermissionsHook() {
		return isPresent("Permissions");
	}

	public boolean attemptEssentialsHook() {
		return isPresent("Essentials");
	}

	private boolean isPresent(String pluginName) {
		Plugin plugin = Main.getPlugin().getServer().getPluginManager().getPlugin("Multiverse");
		if (plugin != null && plugin.isEnabled())
			return true;
		else
			return false;
	}

}

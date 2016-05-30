package main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatFormatter implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		String playerName = event.getPlayer().getName();
		String message = event.getMessage();
		
		if (!HookerPlugin.MULTIVERSE.isPresent()) return;
		
		String format = (String) ConfigSection.CHAT_FORMAT.getValue();
		
		String playerColor = ConfigSection.PLAYER_COLOR.getValue();
		String newFormat = format.replaceAll("%player%", playerColor + playerName);
		
		MultiverseCore mvCore = Hooker.getMultiverseCore();
		MVWorldManager manager = mvCore.getMVWorldManager();
		MultiverseWorld world = manager.getMVWorld(player.getWorld());
		
		String worldColor = ConfigSection.WORLD_COLOR.getValue();
		newFormat = newFormat.replaceAll("%world%", worldColor + world.getAlias());
		
		String messageColor = ConfigSection.MESSAGE_COLOR.getValue();
		newFormat = newFormat.replaceAll("%message%", messageColor + message);
		
		PermissionUser permUser = PermissionsEx.getUser(player);
		String prefix = permUser.getPrefix();
		newFormat = newFormat.replace("%prefix%", prefix);

		event.setFormat(ChatUtilities.colorText(newFormat));
	}
	
}

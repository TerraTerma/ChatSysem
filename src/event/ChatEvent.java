package event;
import configuration.ChatConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.onarandombox.MultiverseCore.api.MultiverseWorld;

import main.Hooker;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import utilities.ChatHelper;

public class ChatEvent implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		String message = event.getMessage();
		String playerName;
		
		String format = (String) ChatConfiguration.CHAT_FORMAT.getValue();
		String newFormat;
		
		playerName = Hooker.getEssentials()
						   .getUser(player)
						   .getNickname();
		
		try {
			
			newFormat = format.replaceAll("%player%", playerName);
			
		} catch (NullPointerException e) {

			String playerColor = (String) ChatConfiguration.PLAYER_COLOR.getValue();
			playerName = player.getDisplayName();
			newFormat = format.replaceAll("%player%", playerColor + playerName);
			
		}
		
		MultiverseWorld world = Hooker.getMultiverseCore()
				.getMVWorldManager()
				.getMVWorld(player.getWorld());
				
		String worldColor = (String) ChatConfiguration.WORLD_COLOR.getValue();
		newFormat = newFormat.replaceAll("%world%", worldColor + world.getAlias());
		
		String messageColor = (String) ChatConfiguration.MESSAGE_COLOR.getValue();
		newFormat = newFormat.replaceAll("%message%", messageColor + message);
		
		String prefix = PermissionsEx.getUser(player)
				.getPrefix();
		
		newFormat = newFormat.replace("%prefix%", prefix);

		event.setFormat(ChatHelper.colorText(newFormat));
	}
	
}

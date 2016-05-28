import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatter implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		String playerName = event.getPlayer().getName();
		String worldName = player.getWorld().getName();
		String message = event.getMessage();
		
		if (!HookerPlugin.MULTIVERSE.isPresent()) return;
		
//		MultiverseCore core = Hooker.getMultiverseCore();
//		MVWorldManager mvwm = core.getMVWorldManager();
		
		String format = (String) ConfigSection.CHAT_FORMAT.getValue();
		
		String playerColor = (String) ConfigSection.PLAYER_COLOR.getValue();
		String newFormat = format.replaceAll("%player%", playerColor + playerName);
		
		String worldColor = (String) ConfigSection.WORLD_COLOR.getValue();
		newFormat = newFormat.replaceAll("%world%", worldColor + worldName);
		
		String messageColor = (String) ConfigSection.MESSAGE_COLOR.getValue();
		newFormat = newFormat.replaceAll("%message%", messageColor + message);

		event.setFormat(ChatUtilities.colorText(newFormat));
	}
	
}

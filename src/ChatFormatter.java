import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatter implements Listener {

	private String format;
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		String playerName = event.getPlayer().getName();
		String worldName = player.getWorld().getName();
		String message = event.getMessage();
		
		String newFormat = format.replaceAll("%player%", playerName);
		newFormat = newFormat.replaceAll("%world%", worldName);
		newFormat = newFormat.replaceAll("%message%", message);

		event.setFormat(newFormat);
	}
	
	/**
	 * Set the format of chat messages.
	 * @param format String representation of the chat format.
	 */
	public void setFormat (String format) {
		this.format = format;
	}

}

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatter implements Listener {

	private String format;

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {

		Player player = event.getPlayer();
		format.replaceAll("%player%", player.getDisplayName());
		format.replaceAll("%world%", player.getWorld().getName());
		event.setFormat(format);
	}

	public void setFormat(String format) {
		this.format = format;
	}

}

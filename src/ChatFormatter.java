import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatter implements Listener {

	private String format;
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		String playerName = event.getPlayer().getDisplayName();
		String worldName = player.getWorld().getName();
		
		format.replaceAll("%player%", playerName);
		format.replaceAll("%world%", worldName);
		
		event.setFormat(format);
	}
	
	public void setFormat (String format) {
		this.format = format;
	}

}

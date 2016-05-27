import java.util.Optional;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MentionEvent implements Listener {

	private String prefix;
	
	public void setPrefix (String prefix) {
		this.prefix = prefix;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		
		String message = event.getMessage();

		Optional<? extends Player> mentionedPlayer = Bukkit.getOnlinePlayers().stream()
				.filter(e -> message.contains(e.getName())).findAny();
		
		if (!mentionedPlayer.isPresent()) return;
		
		Player player = mentionedPlayer.get();
		String playerName = player.getName();
		
		Location playerLoc = player.getLocation();
		player.playSound(playerLoc, Sound.BLOCK_ANVIL_BREAK, 1, 1);
		
		String newMessage = message.replace(playerName, ChatUtilities.colorText(prefix + playerName));
		event.setMessage(newMessage);
	}
	
}

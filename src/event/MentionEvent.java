package event;
import java.util.Optional;

import configuration.ChatConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import main.Hooker;
import utilities.ChatHelper;

public class MentionEvent implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		
		String message = event.getMessage();

		Optional<? extends Player> mentionedPlayer = Bukkit.getOnlinePlayers().stream()
				.filter(e -> message.contains(e.getName())).findAny();
		
		if (!mentionedPlayer.isPresent()) return;
		
		Player player = mentionedPlayer.get();
		String playerName = player.getName();
		
		Location playerLoc = player.getLocation();
		String soundName = (String) ChatConfiguration.MENTION_SOUND.getValue();
		Sound sound = Sound.valueOf(soundName);
		player.playSound(playerLoc, sound, 0.75f, 1f);

		String messageColor = (String) ChatConfiguration.MESSAGE_COLOR.getValue();
		
		Essentials essentials = Hooker.getEssentials();
		User user = essentials.getUser(player);
		
		String mentionPrefix;
		if (user.isAfk()) mentionPrefix = (String) ChatConfiguration.MENTION_AFK_FORMAT.getValue();
		else mentionPrefix = (String) ChatConfiguration.MENTION_FORMAT.getValue();
			
		String newMessage = message.replace(playerName, mentionPrefix + playerName + messageColor);
		
		event.setMessage(ChatHelper.colorText(newMessage));
	}
	
}

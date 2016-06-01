package main;
import java.util.Optional;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

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
		String soundName = ConfigSection.MENTION_SOUND.getValue();
		Sound sound = Sound.valueOf(soundName);
		player.playSound(playerLoc, sound, 0.75f, 1f);

		String messageColor = ConfigSection.MESSAGE_COLOR.getValue();
		
		Essentials essentials = Hooker.getEssentials();
		User user = essentials.getUser(player);
		
		String mentionPrefix;
		if (user.isAfk()) mentionPrefix = ConfigSection.MENTION_AFK_FORMAT.getValue();
		else mentionPrefix = ConfigSection.MENTION_FORMAT.getValue();
			
		String newMessage = message.replace(playerName, mentionPrefix + playerName + messageColor);
		
		event.setMessage(ChatHelper.colorText(newMessage));
	}
	
}

package event;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import configuration.ChatConfiguration;
import main.Hooker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import utilities.ChatHelper;

import java.util.Optional;

public class MentionFormatter {

	String formatMention(AsyncPlayerChatEvent event, String newFormat) {
		
		String message = event.getMessage();

		Optional<? extends Player> mentionedPlayer = Bukkit.getOnlinePlayers().stream()
				.filter(e -> message.contains(e.getName())).findAny();
		
		if (!mentionedPlayer.isPresent()) return null;

		Player player = mentionedPlayer.get();
		String playerName = player.getName();
		
		Location playerLoc = player.getLocation();
		String soundName = (String) ChatConfiguration.MENTION_SOUND.getValue();
		Sound sound = Sound.valueOf(soundName);
		String mentionVolString = (String) ChatConfiguration.MENTION_SOUND_VOLUME.getValue();
		float mentionVolume = Float.parseFloat(mentionVolString);
		player.playSound(playerLoc, sound, mentionVolume, 1f);

		String colorizedFormat = ChatHelper.colorText(newFormat);
		String messageColor = ChatColor.getLastColors(colorizedFormat);

		if (messageColor == null || messageColor.equals(""))
			messageColor = ChatColor.WHITE.toString();

		Essentials essentials = Hooker.getEssentials();
		User user = essentials.getUser(player);
		
		String mentionPrefix;
		if (user.isAfk()) mentionPrefix = (String) ChatConfiguration.MENTION_AFK_FORMAT.getValue();
		else mentionPrefix = (String) ChatConfiguration.MENTION_FORMAT.getValue();
			
		String newMessage = message.replace(playerName, mentionPrefix + playerName + messageColor);
		newFormat = newFormat.replace("%message%", newMessage);

		return newFormat;
	}
	
}

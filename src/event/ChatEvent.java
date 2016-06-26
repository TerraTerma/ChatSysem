package event;
import configuration.ChatConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.onarandombox.MultiverseCore.api.MultiverseWorld;

import main.Hooker;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import utilities.ChatHelper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ChatEvent implements Listener {

	private MentionEvent mentionEvent = new MentionEvent();

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {

		Player player = event.getPlayer();
		String message = event.getMessage();

		String newFormat = (String) ChatConfiguration.CHAT_FORMAT.getValue();

		//Add the player name to the format
		String playerName = Hooker.getEssentials()
				.getUser(player)
				.getNickname();
		try {
			newFormat = newFormat.replaceAll("%player%", playerName);
		} catch (NullPointerException e) {
			playerName = player.getDisplayName();
			newFormat = newFormat.replaceAll("%player%", playerName);
		}

		//Add the world name to the format
		MultiverseWorld world = Hooker.getMultiverseCore()
				.getMVWorldManager()
				.getMVWorld(player.getWorld());
		newFormat = newFormat.replaceAll("%world%", world.getAlias());

		//Add the prefix to the format
		String prefix = PermissionsEx.getUser(player).getPrefix();
		newFormat = newFormat.replace("%prefix%", prefix);

		//Check to see if there was a player that was mentioned.
		Optional<? extends Player> mentionedPlayer = Bukkit.getOnlinePlayers()
				.stream()
				.filter(e -> message.contains(e.getName()))
				.findAny();

		if (mentionedPlayer.isPresent())
			newFormat = mentionEvent.formatMention(event, newFormat);
		else newFormat = newFormat.replace("%message%", message);

		event.setFormat(ChatHelper.colorText(newFormat));

	}
	
}

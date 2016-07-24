package event;

import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import configuration.ChatConfiguration;
import configuration.GroupConfiguration;
import main.Hooker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import utilities.ChatHelper;
import utilities.FormatTemplate;
import utilities.MentionFormatter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class ChatListener implements Listener {

	private MentionFormatter mentionEvent = new MentionFormatter();

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {

	    event.setCancelled(true);
	    
		final Player player = event.getPlayer();
		final String message = event.getMessage();
		final String worldName = player.getWorld().getName();
        
		//Get the specified group format
		PermissionUser permissionUser = PermissionsEx.getUser(player);
		List<String> identifiers = permissionUser.getParentIdentifiers(worldName);
		String firstGroup = identifiers.get(0);
		String newFormat = GroupConfiguration
				.getGroupFormat(firstGroup);
		System.out.println("The new format is " + newFormat);

		//Add the player name to the format
		String playerName = player.getDisplayName();
		newFormat = newFormat.replaceAll("%player%", playerName);

		//Add the world name to the format
		MultiverseWorld world = Hooker.getMultiverseCore()
				.getMVWorldManager()
				.getMVWorld(player.getWorld());
		newFormat = newFormat.replaceAll("%world%", world.getAlias());

		//Add the prefix to the format
		String prefix = PermissionsEx.getUser(player).getPrefix();
		newFormat = newFormat.replace("%prefix%", prefix);

		// Add the time-stamp to the chat
        boolean timestamp = (boolean) ChatConfiguration.TIMESTAMP.getValue();
        if (timestamp) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("h:m:ss");
            LocalTime localTime = LocalTime.now();
            String formattedTime = localTime.format(dateTimeFormatter);
            newFormat = newFormat.replaceAll("%time%", formattedTime);
        }

		//Check to see if there was a player that was mentioned.
		Optional<? extends Player> mentionedPlayer = Bukkit.getOnlinePlayers()
				.stream()
				.filter(e -> message.contains(e.getName()))
				.findAny();

		if (mentionedPlayer.isPresent()) {
			FormatTemplate formatTemplate = new FormatTemplate(newFormat);
			formatTemplate.setMessage(message);
			formatTemplate.setPlayer(player);
			newFormat = mentionEvent.formatMention(formatTemplate);
		}
		else newFormat = newFormat.replace("%message%", message);

		event.setFormat(ChatHelper.colorText(newFormat));

	}
	
}

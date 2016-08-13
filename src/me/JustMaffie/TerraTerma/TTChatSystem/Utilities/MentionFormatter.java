package me.JustMaffie.TerraTerma.TTChatSystem.Utilities;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import me.JustMaffie.TerraTerma.TTChatSystem.Hooker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import java.util.Optional;

public class MentionFormatter {

	public String formatMention(FormatTemplate formatTemplate) {

		String newFormat = formatTemplate.getFormat();
		String message = formatTemplate.getMessage();

		Optional<? extends Player> mentionedPlayer = Bukkit.getOnlinePlayers().stream()
				.filter(e -> message.contains(e.getName())).findAny();
		
		if (!mentionedPlayer.isPresent()) return null;

		Player player = mentionedPlayer.get();
		String playerName = player.getName();
		

		String colorizedFormat = ChatHelper.colorText(newFormat);
		String messageColor = ChatColor.getLastColors(colorizedFormat);

		if (messageColor == null || messageColor.equals(""))
			messageColor = ChatColor.WHITE.toString();

		Essentials essentials = Hooker.getEssentials();
		User user = essentials.getUser(player);
		
		String mentionPrefix;
		if (user.isAfk()) mentionPrefix = (String) ChatConfig."Evan put in code to get the string Mention.AFK";
		else mentionPrefix = (String) ChatConfig."Evan put in code to get the string Mention.NotAFK";
			
		String newMessage = message.replace(playerName, mentionPrefix + playerName + messageColor);
		newFormat = newFormat.replace("%message%", newMessage);

		return newFormat;
	}
	
}

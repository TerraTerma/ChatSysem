package me.JustMaffie.TerraTerma.TTChatSystem.Utilities;

import java.io.File;
import java.util.Optional;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import TTCore.Savers.Saver;
import me.JustMaffie.TerraTerma.TTChatSystem.Hooker;

public class MentionFormatter {

	public String formatMention(FormatTemplate formatTemplate) {

		
		Saver saver = new Saver(new File("plugins/TTChatSystem/ChatConfig.yml"));
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
		if (user.isAfk()) mentionPrefix = (String) saver.get(String.class, "Mention.AFK");
		else mentionPrefix = (String) saver.get(String.class, "Mention.Format");
			
		String newMessage = message.replace(playerName, mentionPrefix + playerName + messageColor);
		newFormat = newFormat.replace("%message%", newMessage);

		return newFormat;
	}
	
}

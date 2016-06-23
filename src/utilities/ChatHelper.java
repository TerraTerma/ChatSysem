package utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Collection;

public abstract class ChatHelper {

	/**
	 * Color a string of text using color codes.
	 * @param text The text to color.
	 * @return String of colored text.
	 */
	public static String colorText (String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

	public static void broadcastGreenMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.GREEN + message);
	}

	public static void broadcastAquaMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.AQUA + message);
	}

	public static void broadcastRedMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.RED + message);
	}

	public static void broadcastPinkMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + message);
	}

	public static void broadcastYellowMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.YELLOW + message);
	}

	public static void broadcastBlackMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.BLACK + message);
	}

	public static void broadcastDarkBlueMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.DARK_BLUE + message);
	}

	public static void broadcastDarkGreenMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.DARK_GREEN + message);
	}

	public static void broadcastDarkAquaMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.DARK_AQUA + message);
	}

	public static void broadcastDarkRedMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.DARK_RED + message);
	}

	public static void broadcastDarkPurpleMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + message);
	}

	public static void broadcastGoldMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.GOLD + message);
	}

	public static void broadcastGrayMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.GRAY + message);
	}

	public static void broadcastDarkGrayMessage (String message) {
		Bukkit.broadcastMessage(ChatColor.DARK_GRAY + message);
	}

	public static void sendGreenMessage (CommandSender sender, String message) {
		sender.sendMessage(ChatColor.GREEN + message);
	}

	public static void sendAquaMessage (CommandSender sender, String message) {
		sender.sendMessage(ChatColor.AQUA + message);
	}

	public static void sendRedMessage (CommandSender sender, String message) {
		sender.sendMessage(ChatColor.RED + message);
	}

	public static void sendPinkMessage (CommandSender sender, String message) {
		sender.sendMessage(ChatColor.LIGHT_PURPLE + message);
	}

	public static void sendYellowMessage (CommandSender sender, String
			message) {
		sender.sendMessage(ChatColor.YELLOW + message);
	}

	public static void sendBlackMessage (CommandSender sender, String message) {
		sender.sendMessage(ChatColor.BLACK + message);
	}

	public static void sendDarkBlueMessage (CommandSender sender, String
			message) {
		sender.sendMessage(ChatColor.DARK_BLUE + message);
	}

	public static void sendDarkGreenMessage (CommandSender sender, String
			message) {
		sender.sendMessage(ChatColor.DARK_GREEN + message);
	}

	public static void sendDarkAquaMessage (CommandSender sender, String
			message) {
		sender.sendMessage(ChatColor.DARK_AQUA + message);
	}

	public static void sendDarkRedMessage (CommandSender sender, String
			message) {
		sender.sendMessage(ChatColor.DARK_RED + message);
	}

	public static void sendDarkPurpleMessage (CommandSender sender, String
			message) {
		sender.sendMessage(ChatColor.DARK_PURPLE + message);
	}

	public static void sendGoldMessage (CommandSender sender, String message) {
		sender.sendMessage(ChatColor.GOLD + message);
	}

	public static void sendGrayMessage (CommandSender sender, String message) {
		sender.sendMessage(ChatColor.GRAY + message);
	}

	public static void sendDarkGrayMessage (CommandSender sender, String
			message) {
		sender.sendMessage(ChatColor.DARK_GRAY + message);
	}

	public static void sendBlueMessage (CommandSender sender, String message) {
		sender.sendMessage(ChatColor.BLUE + message);
	}


	public static void sendGreenMessage (Collection<CommandSender> sender,
										 String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendGreenMessage(e, message));
	}

	public static void sendAquaMessage (Collection<CommandSender> sender,
										String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendAquaMessage(e, message));
	}

	public static void sendBlueMessage (Collection<CommandSender> sender,
										String message) {
		sender.stream()
				.forEach(e -> ChatHelper.sendBlueMessage(e, message));
	}

	public static void sendRedMessage (Collection<CommandSender> sender, String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendRedMessage(e, message));
	}

	public static void sendPinkMessage (Collection<CommandSender> sender,
										String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendPinkMessage(e, message));
	}

	public static void sendYellowMessage (Collection<CommandSender> sender,
										  String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendYellowMessage(e, message));
	}

	public static void sendBlackMessage (Collection<CommandSender> sender,
										 String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendBlackMessage(e, message));
	}

	public static void sendDarkBlueMessage (Collection<CommandSender> sender,
											String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendDarkBlueMessage(e, message));
	}

	public static void sendDarkGreenMessage (Collection<CommandSender> sender,
											 String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendDarkGreenMessage(e, message));
	}

	public static void sendDarkAquaMessage (Collection<CommandSender> sender,
											String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendDarkAquaMessage(e, message));
	}

	public static void sendDarkRedMessage (Collection<CommandSender> sender,
										   String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendDarkRedMessage(e, message));
	}

	public static void sendDarkPurpleMessage (Collection<CommandSender> sender,
											  String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendDarkPurpleMessage(e, message));
	}

	public static void sendGoldMessage (Collection<CommandSender> sender,
										String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendGoldMessage(e, message));
	}

	public static void sendGrayMessage (Collection<CommandSender> sender,
										String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendGrayMessage(e, message));
	}

	public static void sendDarkGrayMessage (Collection<CommandSender> sender,
											String
			message) {
		sender.stream()
		.forEach(e -> ChatHelper.sendDarkGrayMessage(e, message));
	}

}

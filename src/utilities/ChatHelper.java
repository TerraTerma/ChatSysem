package utilities;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import static org.bukkit.ChatColor.*;

import java.util.Collection;

public abstract class ChatHelper {

	/**
	 * Color a string of text using color codes.
	 * @param text The text to color.
	 * @return String of colored text.
	 */
	public static String colorText (String text) {
		return translateAlternateColorCodes('&', text);
	}

	public static void broadcastGreenMessage (String message) {
		Bukkit.broadcastMessage(GREEN + message);
	}
	public static void broadcastBoldGreenMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + GREEN + message);
	}
	public static void broadcastAquaMessage (String message) {
		Bukkit.broadcastMessage(AQUA + message);
	}
	public static void broadcastBoldAquaMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + AQUA + message);
	}
	public static void broadcastRedMessage (String message) {
		Bukkit.broadcastMessage(RED + message);
	}
	public static void broadcastBoldRedMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + RED + message);
	}
	public static void broadcastPinkMessage (String message) {
		Bukkit.broadcastMessage(LIGHT_PURPLE + message);
	}
	public static void broadcastBoldLightPurpleMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + LIGHT_PURPLE + message);
	}
	public static void broadcastYellowMessage (String message) {
		Bukkit.broadcastMessage(YELLOW + message);
	}

	public static void broadcastBlackMessage (String message) {
		Bukkit.broadcastMessage(BLACK + message);
	}
	public static void broadcastBoldBlackMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + BLACK + message);
	}
	public static void broadcastDarkBlueMessage (String message) {
		Bukkit.broadcastMessage(DARK_BLUE + message);
	}
	public static void broadcastBoldDarkBlueMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + DARK_BLUE + message);
	}
	public static void broadcastDarkGreenMessage (String message) {
		Bukkit.broadcastMessage(DARK_GREEN + message);
	}
	public static void broadcastBoldDarkGreenMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + DARK_GREEN + message);
	}
	public static void broadcastDarkAquaMessage (String message) {
		Bukkit.broadcastMessage(DARK_AQUA + message);
	}

	public static void broadcastDarkRedMessage (String message) {
		Bukkit.broadcastMessage(DARK_RED + message);
	}

	public static void broadcastDarkPurpleMessage (String message) {
		Bukkit.broadcastMessage(DARK_PURPLE + message);
	}

	public static void broadcastGoldMessage (String message) {
		Bukkit.broadcastMessage(GOLD + message);
	}

	public static void broadcastGrayMessage (String message) {
		Bukkit.broadcastMessage(GRAY + message);
	}

	public static void broadcastDarkGrayMessage (String message) {
		Bukkit.broadcastMessage(DARK_GRAY + message);
	}
	public static void broadcastBlueMessage (String message) {
		Bukkit.broadcastMessage(BLUE + message);
	}
	public static void broadcastBoldMessage (String message) {
		Bukkit.broadcastMessage(BOLD + message);
	}
	public static void broadcastBoldDarkAquaMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + DARK_AQUA + message);
	}
	public static void broadcastBoldDarkRedMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + DARK_RED + message);
	}
	public static void broadcastBoldDarkPurpleMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + DARK_PURPLE + message);
	}
	public static void broadcastBoldBlueMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + BLUE + message);
	}
	public static void broadcastBoldDarkGrayMessage (String message){
		Bukkit.broadcastMessage(BOLD + "" + DARK_GRAY + message);
	}
	public static void broadcastBoldGrayMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + GRAY + message);
	}
	public static void broadcastBoldGoldMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + GOLD + message);
	}
	public static void broadcastBoldWhiteMessage (String message) {
		Bukkit.broadcastMessage(BOLD + "" + WHITE + message);
	}
	public static void broadcastWhiteMessage (String message) {
		Bukkit.broadcastMessage(WHITE + message);
	}
	public static void sendGreenMessage (CommandSender sender, String message) {
		sender.sendMessage(GREEN + message);
	}
	public static void sendBoldGreenMessage (CommandSender sender, String message) {
		sender.sendMessage(GREEN + "" + BOLD + message);
	}
	public static void sendAquaMessage (CommandSender sender, String message) {
		sender.sendMessage(AQUA + message);
	}
	public static void sendBoldAquaMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + AQUA + message);
	}
	public static void sendRedMessage (CommandSender sender, String message) {
		sender.sendMessage(RED + message);
	}
	public static void sendBoldRedMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + RED + message);
	}

	public static void sendPinkMessage (CommandSender sender, String message) {
		sender.sendMessage(LIGHT_PURPLE + message);
	}
	public static void sendBoldLightPurpleMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + LIGHT_PURPLE + message);
	}
	public static void sendYellowMessage (CommandSender sender, String
			message) {
		sender.sendMessage(YELLOW + message);
	}
	public static void sendBoldYellowMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + YELLOW + message);
	}
	public static void sendBlackMessage (CommandSender sender, String message) {
		sender.sendMessage(BLACK + message);
	}
	public static void sendBoldBlackMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + BLACK + message);
	}
	public static void sendDarkBlueMessage (CommandSender sender, String
			message) {
		sender.sendMessage(DARK_BLUE + message);
	}
	public static void sendBoldDarkBlueMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + DARK_BLUE + message);
	}
	public static void sendDarkGreenMessage (CommandSender sender, String
			message) {
		sender.sendMessage(DARK_GREEN + message);
	}
	public static void sendBoldDarkGreenMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + DARK_GREEN + message);
	}
	public static void sendDarkAquaMessage (CommandSender sender, String
			message) {
		sender.sendMessage(DARK_AQUA + message);
	}
	public static void sendBoldDarkAquaMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + DARK_AQUA + message);
	}
	public static void sendDarkRedMessage (CommandSender sender, String
			message) {
		sender.sendMessage(DARK_RED + message);
	}
	public static void sendBoldDarkRedMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + DARK_RED + message);
	}
	public static void sendDarkPurpleMessage (CommandSender sender, String
			message) {
		sender.sendMessage(DARK_PURPLE + message);
	}
	public static void sendBoldDarkPurpleMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + DARK_PURPLE + message);
	}
	public static void sendGoldMessage (CommandSender sender, String message) {
		sender.sendMessage(GOLD + message);
	}
	public static void sendBoldGoldMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + GOLD + message);
	}
	public static void sendGrayMessage (CommandSender sender, String message) {
		sender.sendMessage(GRAY + message);
	}
	public static void sendBoldGrayMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + GRAY + message);
	}
	public static void sendDarkGrayMessage (CommandSender sender, String
			message) {
		sender.sendMessage(DARK_GRAY + message);
	}
	public static void sendBoldDarkGrayMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + DARK_GRAY + message);
	}
	public static void sendBlueMessage (CommandSender sender, String message) {
		sender.sendMessage(BLUE + message);
	}
	public static void sendBoldBlueMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + BLUE + message);
	}
	public static void sendBoldWhiteMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + "" + WHITE + message);
	}
	public static void sendBoldMessage (CommandSender sender, String message) {
		sender.sendMessage(BOLD + message);
	}
	public static void sendGreenMessage (Collection<CommandSender> sender,
										 String message) {
		sender.forEach(e -> ChatHelper.sendGreenMessage(e, message));
	}

	public static void sendAquaMessage (Collection<CommandSender> sender,
										String message) {
		sender.forEach(e -> ChatHelper.sendAquaMessage(e, message));
	}

	public static void sendBlueMessage (Collection<CommandSender> sender,
										String message) {
		sender.forEach(e -> ChatHelper.sendBlueMessage(e, message));
	}

	public static void sendRedMessage (Collection<CommandSender> sender,
									   String message) {
		sender.forEach(e -> ChatHelper.sendRedMessage(e, message));
	}

	public static void sendPinkMessage (Collection<CommandSender> sender,
										String message) {
		sender.forEach(e -> ChatHelper.sendPinkMessage(e, message));
	}

	public static void sendYellowMessage (Collection<CommandSender> sender,
										  String message) {
		sender.forEach(e -> ChatHelper.sendYellowMessage(e, message));
	}

	public static void sendBlackMessage (Collection<CommandSender> sender,
										 String message) {
		sender.forEach(e -> ChatHelper.sendBlackMessage(e, message));
	}

	public static void sendDarkBlueMessage (Collection<CommandSender> sender,
											String message) {
		sender.forEach(e -> ChatHelper.sendDarkBlueMessage(e, message));
	}

	public static void sendDarkGreenMessage (Collection<CommandSender> sender,
											 String message) {
		sender.forEach(e -> ChatHelper.sendDarkGreenMessage(e, message));
	}

	public static void sendDarkAquaMessage (Collection<CommandSender> sender,
											String message) {
		sender.forEach(e -> ChatHelper.sendDarkAquaMessage(e, message));
	}

	public static void sendDarkRedMessage (Collection<CommandSender> sender,
										   String message) {
		sender.forEach(e -> ChatHelper.sendDarkRedMessage(e, message));
	}

	public static void sendDarkPurpleMessage (Collection<CommandSender> sender,
											  String message) {
		sender.forEach(e -> ChatHelper.sendDarkPurpleMessage(e, message));
	}

	public static void sendGoldMessage (Collection<CommandSender> sender,
										String message) {
		sender.forEach(e -> ChatHelper.sendGoldMessage(e, message));
	}

	public static void sendGrayMessage (Collection<CommandSender> sender,
										String message) {
		sender.forEach(e -> ChatHelper.sendGrayMessage(e, message));
	}

	public static void sendDarkGrayMessage (Collection<CommandSender> sender,
											String message) {
		sender.forEach(e -> ChatHelper.sendDarkGrayMessage(e, message));
	}

}

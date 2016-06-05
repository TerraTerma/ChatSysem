package utilities;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

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
	
	public static void sendGreenMessage (Player player, String message) {
		player.sendMessage(ChatColor.GREEN + message);
	}
	
	public static void sendAquaMessage (Player player, String message) {
		player.sendMessage(ChatColor.AQUA + message);
	}
	
	public static void sendRedMessage (Player player, String message) {
		player.sendMessage(ChatColor.RED + message);
	}
	
	public static void sendPinkMessage (Player player, String message) {
		player.sendMessage(ChatColor.LIGHT_PURPLE + message);
	}
	
	public static void sendYellowMessage (Player player, String message) {
		player.sendMessage(ChatColor.YELLOW + message);
	}
	
	public static void sendBlackMessage (Player player, String message) {
		player.sendMessage(ChatColor.BLACK + message);
	}
	
	public static void sendDarkBlueMessage (Player player, String  message) {
		player.sendMessage(ChatColor.DARK_BLUE + message);
	}
	
	public static void sendDarkGreenMessage (Player player, String message) {
		player.sendMessage(ChatColor.DARK_GREEN + message);
	}
	
	public static void sendDarkAquaMessage (Player player, String message) {
		player.sendMessage(ChatColor.DARK_AQUA + message);
	}
	
	public static void sendDarkRedMessage (Player player, String message) {
		player.sendMessage(ChatColor.DARK_RED + message);
	}
	
	public static void sendDarkPurpleMessage (Player player, String message) {
		player.sendMessage(ChatColor.DARK_PURPLE + message);
	}
	
	public static void sendGoldMessage (Player player, String message) {
		player.sendMessage(ChatColor.GOLD + message);
	}
	
	public static void sendGrayMessage (Player player, String message) {
		player.sendMessage(ChatColor.GRAY + message);
	}
	
	public static void sendDarkGrayMessage (Player player, String message) {
		player.sendMessage(ChatColor.DARK_GRAY + message);
	}
	
	
	public static void sendGreenMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendGreenMessage(e, message));
	}
	
	public static void sendAquaMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendAquaMessage(e, message));
	}
	
	public static void sendRedMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendRedMessage(e, message));
	}
	
	public static void sendPinkMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendPinkMessage(e, message));
	}
	
	public static void sendYellowMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendYellowMessage(e, message));
	}
	
	public static void sendBlackMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendBlackMessage(e, message));
	}
	
	public static void sendDarkBlueMessage (Collection<Player> player, String  message) {
		player.stream()
		.forEach(e -> ChatHelper.sendDarkBlueMessage(e, message));
	}
	
	public static void sendDarkGreenMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendDarkGreenMessage(e, message));
	}
	
	public static void sendDarkAquaMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendDarkAquaMessage(e, message));
	}
	
	public static void sendDarkRedMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendDarkRedMessage(e, message));
	}
	
	public static void sendDarkPurpleMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendDarkPurpleMessage(e, message));
	}
	
	public static void sendGoldMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendGoldMessage(e, message));
	}
	
	public static void sendGrayMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendGrayMessage(e, message));
	}
	
	public static void sendDarkGrayMessage (Collection<Player> player, String message) {
		player.stream()
		.forEach(e -> ChatHelper.sendDarkGrayMessage(e, message));
	}

}

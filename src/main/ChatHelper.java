package main;
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
	
}

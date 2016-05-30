package main;
import org.bukkit.ChatColor;

public abstract class ChatUtilities {

	/**
	 * Color a string of text using color codes.
	 * @param text The text to color.
	 * @return String of colored text.
	 */
	public static String colorText (String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
}

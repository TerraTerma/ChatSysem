package utilities;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import main.Main;

public abstract class ChatGameHelper {

	private static Main main;
	private static BukkitScheduler scheduler;
	
	public static void load (Main main) {
		ChatGameHelper.main = main;
		scheduler = Bukkit.getScheduler();
	}
	
	public static BukkitTask runRepeatingTask (Runnable runnable, long start, long interval) {
		return scheduler.runTaskTimer(main, runnable, start, interval);
	}
	
	public static BukkitTask runDelayedTask (Runnable runnable, long delay) {
		return scheduler.runTaskLater(main, runnable, delay);
	}
	
}
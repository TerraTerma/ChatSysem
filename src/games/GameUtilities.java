package games;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import main.Main;

public abstract class GameUtilities {

	private static Main main;
	private static BukkitScheduler scheduler;
	
	public static void load (Main main) {
		GameUtilities.main = main;
		scheduler = Bukkit.getScheduler();
	}
	
	public static BukkitTask runTimer (Runnable runnable, long start, long interval) {
		return scheduler.runTaskTimer(main, runnable, start, interval);
	}
	
	public static void cancelTask (int id) {
		scheduler.cancelTask(id);
	}

	public static void registerEvent (ChatGame game) {
		main.getServer().getPluginManager().registerEvents(game, main);
	}
	
}

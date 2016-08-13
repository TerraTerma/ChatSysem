package me.JustMaffie.TerraTerma.TTChatSystem.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import me.JustMaffie.TerraTerma.TTChatSystem.Main;

public class ChatGameHelper {

	private static Main mainPlugin;
	private static BukkitScheduler scheduler;
	
	public ChatGameHelper (Main main) {
		mainPlugin = main;
		scheduler = Bukkit.getScheduler();
	}
	
	public static BukkitTask runRepeatingTask (Runnable runnable, long start, long interval) {
		return scheduler.runTaskTimer(mainPlugin, runnable, start, interval);
	}
	
	public static BukkitTask runDelayedTask (Runnable runnable, long delay) {
		return scheduler.runTaskLater(mainPlugin, runnable, delay);
	}
	
}

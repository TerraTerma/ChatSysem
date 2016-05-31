package games;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitTask;

public abstract class ChatGame {

	protected String name = "Chat Game";
	protected int minPlayers = 2;
	protected int maxTime = 60;
	protected int runTime = 0;
	protected boolean running;
	
	protected BukkitTask gameTask;
	
	public ChatGame (String name, int minPlayers) {
		this.name = name;
	}
	
	protected String getName () {
		return name;
	}
	
	protected int getMinimumPlayers () {
		return minPlayers;
	}
	
	protected int getMaximumTime () {
		return maxTime;
	}
	
	protected int getRuntime () {
		return runTime;
	}
	
	protected boolean isRunning () {
		return running;
	}
	
	protected void start () {
		running = true;
		
		gameTask = GameUtilities.runTimer(new Runnable () {
			
			public void run () {
				
				if (runTime >= maxTime) {
					stop();
					return;
				}
				
				runTime++;
				System.out.println("The runtime is " + runTime);
			}
			
		}, 20, 20);
	}
	
	protected void stop () {
		running = false;
		runTime = 0;
		gameTask.cancel();
		
		System.out.println("Called the stop method.");
	}
	
	protected abstract void onPlayerChat (AsyncPlayerChatEvent event);
	
}
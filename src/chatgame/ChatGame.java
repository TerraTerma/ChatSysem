package chatgame;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitTask;

public abstract class ChatGame {

	private String name;
	
	private int minPlayers;
	private int maxTime;
	private boolean running;
	
	private BukkitTask gameTask;
	
	public ChatGame (String name, int minPlayers, int maxTime) {
		this.name = name;
		this.minPlayers = minPlayers;
		this.maxTime = maxTime;
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
	
	protected boolean isRunning () {
		return running;
	}
	
	protected void start () {
		running = true;
		gameTask = ChatGameHelper.runTimer(new ChatGameRunnable(this), 20, 20);
	}
	
	protected void stop () {
		running = false;
		gameTask.cancel();
		
		System.out.println("Called the stop method.");
	}
	
	protected Player player;
	protected String message;
	
	protected void onPlayerChat (AsyncPlayerChatEvent event) {
		player = event.getPlayer();
		message = event.getMessage();
		
		System.out.println("Chat game chat method.");
	}
	
}

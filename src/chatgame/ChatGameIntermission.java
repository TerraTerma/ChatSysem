package chatgame;

import org.bukkit.scheduler.BukkitTask;

import utilities.ChatGameHelper;

public class ChatGameIntermission implements Runnable {

	private final int intermission;
	
	private boolean inProgress;
	
	private BukkitTask bukkitTask;
	
	public ChatGameIntermission (int intermission) {
		this.intermission = intermission;
	}
	
	public boolean isInProgress () {
		return inProgress;
	}
	
	public void run () {

		ChatGameQueue.startRandomGame();
		inProgress = false;
		bukkitTask.cancel();
		
	}
	
	public void beginIntermission () {
		inProgress = true;
		bukkitTask = ChatGameHelper.runDelayedTask(this, 20 * intermission);
	}
	
}

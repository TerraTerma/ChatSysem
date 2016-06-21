package chatgame;

import org.bukkit.scheduler.BukkitTask;
import utilities.ChatGameHelper;

class ChatGameIntermission implements Runnable {

	private final int intermission;
	
	private boolean inProgress;
	
	private BukkitTask bukkitTask;
	
	ChatGameIntermission (int intermission) {
		this.intermission = intermission;
	}
	
	boolean isInProgress () {
		return inProgress;
	}
	
	public void run () {

		ChatGameQueue.startRandomGame();
		inProgress = false;
		bukkitTask.cancel();
		
	}
	
	void beginIntermission () {
		inProgress = true;
		bukkitTask = ChatGameHelper.runDelayedTask(this, 20 * intermission);
	}
	
}

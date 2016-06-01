package chatgame;

import org.bukkit.scheduler.BukkitTask;

public class ChatGameIntermission implements Runnable {

	private final int intermission;
	
	private boolean inProgress;
	
	private BukkitTask bukkitTask;
	
	private ChatGameQueue chatGameQueue;
	
	public ChatGameIntermission (ChatGameQueue chatGameQueue, int intermission) {
		this.intermission = intermission;
		this.chatGameQueue = chatGameQueue;
	}
	
	public boolean isInProgress () {
		return inProgress;
	}
	
	public void run () {

		chatGameQueue.startRandomGame();
		inProgress = false;
		bukkitTask.cancel();
		
	}
	
	public void beginIntermission () {
		inProgress = true;
		bukkitTask = ChatGameHelper.runDelayedTask(this, 20 * intermission);
	}
	
}

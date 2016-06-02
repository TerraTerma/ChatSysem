package chatgame;

import java.util.List;

import chatgame.games.ChatGame;

public class IntermissionScheduler implements Runnable {
	
	private ChatGameQueue chatGameQueue;
	
	public IntermissionScheduler (ChatGameQueue chatGameQueue) {
		this.chatGameQueue = chatGameQueue;
	}
	
	public void run () {
		
		List<ChatGame> chatGames = chatGameQueue.getChatGames();
		
		boolean runningGame = chatGames.stream()
		.anyMatch(e -> e.isRunning());
		
		ChatGameIntermission chatGameIntermission = 
				chatGameQueue.getChatGameIntermission();
		
		boolean intermissionInProgress = 
				chatGameIntermission
				.isInProgress();
		
		if (!runningGame && !intermissionInProgress)
			chatGameIntermission
			.beginIntermission();
		
	}

	public void beginMonitor () {
		ChatGameHelper.runRepeatingTask(this, 20, 20);
	}
	
}

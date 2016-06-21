package chatgame;

import java.util.List;

import utilities.ChatGameHelper;

public class IntermissionScheduler implements Runnable {
	
	public void run () {
		
		List<ChatGame> chatGames = ChatGameQueue.getChatGames();
		
		boolean runningGame = chatGames.stream()
		.anyMatch(e -> e.isRunning());
		
		ChatGameIntermission chatGameIntermission = 
				ChatGameQueue.getChatGameIntermission();
		
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

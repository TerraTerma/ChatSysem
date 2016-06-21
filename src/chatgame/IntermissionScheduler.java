package chatgame;

import java.util.List;

import utilities.ChatGameHelper;

class IntermissionScheduler implements Runnable {
	
	public void run () {
		
		List<ChatGame> chatGames = ChatGameQueue.getChatGames();
		
		boolean runningGame = chatGames.stream()
		.anyMatch(ChatGame::isRunning);
		
		ChatGameIntermission chatGameIntermission = 
				ChatGameQueue.getChatGameIntermission();
		
		boolean intermissionInProgress = 
				chatGameIntermission
				.isInProgress();
		
		if (!runningGame && !intermissionInProgress)
			chatGameIntermission
			.beginIntermission();
		
	}

	void beginMonitor () {
		ChatGameHelper.runRepeatingTask(this, 20, 20);
	}
	
}

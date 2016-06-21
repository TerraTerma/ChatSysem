package chatgame;

class ChatGameRunnable implements Runnable {

	private ChatGame chatGame;
	
	private int runTime = 0;
	private int maxTime = 0;
	
	ChatGameRunnable (ChatGame chatGame) {
		this.chatGame = chatGame;
		this.maxTime = chatGame.getMaximumTime();
	}
	
	public void run () {
		
		if (runTime >= maxTime) {
			chatGame.stop();
			runTime = 0;
			return;
		}
		
		runTime++;
		
		System.out.println(runTime);
		
	}
	
	protected int getRuntime () {
		return runTime;
	}
	
}

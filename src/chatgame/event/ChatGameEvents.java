package chatgame.event;

import chatgame.ChatGame;
import utilities.ChatHelper;

public class ChatGameEvents implements ChatGameListener {

	@Override
	public void onEventFire(ChatGameEvent event) {

		ChatGameWinEvent winEvent;

		ChatGame chatGame = event.getChatGame();
		String name = chatGame.getName();

		if (event instanceof ChatGameWinEvent) {
			winEvent = (ChatGameWinEvent) event;

			ChatHelper.broadcastGoldMessage(winEvent.getWinner().getName()
			+ " has won " + name + ".");

		}

		if (event instanceof ChatGameEndEvent)
			ChatHelper.broadcastGoldMessage(name + " has ended.");

		event.getChatGame().stop();

	}

}

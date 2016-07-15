package main;

import chatgame.ChatGame;
import chatgame.event.ChatGameEndEvent;
import chatgame.event.ChatGameEvent;
import chatgame.event.ChatGameListener;
import chatgame.event.ChatGameWinEvent;
import utilities.ChatHelper;

class ChatGameEvents implements ChatGameListener {

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

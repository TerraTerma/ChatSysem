package main;

import chatgame.event.ChatGameEndEvent;
import chatgame.event.ChatGameEvent;
import chatgame.event.ChatGameWinEvent;
import chatgame.event.ChatGameListener;
import utilities.ChatHelper;

class ChatGameEvents implements ChatGameListener {

	@Override
	public void onEventFire(ChatGameEvent event) {

		ChatGameWinEvent winEvent;
		ChatGameEndEvent endEvent;

		if (event instanceof ChatGameWinEvent) {
			winEvent = (ChatGameWinEvent) event;

			ChatHelper.broadcastGreenMessage(winEvent.getWinner().getName()
			+ " has won " + winEvent.getChatGame().getName() + ".");

		}

		if (event instanceof ChatGameEndEvent) {
			endEvent = (ChatGameEndEvent) event;

			ChatHelper.broadcastGoldMessage
					(endEvent.getChatGame().getName() + " has ended.");

		}

		event.getChatGame().stop();

	}

}

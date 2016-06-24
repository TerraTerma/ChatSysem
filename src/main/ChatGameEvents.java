package main;

import chatgame.ChatGame;
import chatgame.event.ChatGameEndEvent;
import chatgame.event.ChatGameEvent;
import chatgame.event.ChatGameWinEvent;
import chatgame.event.ChatGameListener;
import chatgame.letter.LetterGame;
import utilities.ChatHelper;

class ChatGameEvents implements ChatGameListener {

	@Override
	public void onEventFire(ChatGameEvent event) {

		ChatGameWinEvent winEvent;

		ChatGame chatGame = event.getChatGame();
		String name = chatGame.getName();

		if (event instanceof ChatGameWinEvent) {
			winEvent = (ChatGameWinEvent) event;

			ChatHelper.broadcastGreenMessage(winEvent.getWinner().getName()
			+ " has won " + name + ".");

		}

		if (event instanceof ChatGameEndEvent) {

			if (chatGame instanceof LetterGame) {
				LetterGame letterGame = (LetterGame) chatGame;
				int guesses = letterGame.getGuesses();
				ChatHelper.broadcastYellowMessage(name + " has ended" +
						" with a total of " + guesses + " guesses.");
			}

			ChatHelper.broadcastGoldMessage
					(name + " has ended.");

		}

		event.getChatGame().stop();

	}

}

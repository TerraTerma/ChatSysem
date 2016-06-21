package main;

import chatgame.ChatGame;
import chatgame.event.ChatGameEndEvent;
import chatgame.event.ChatGameLoseEvent;
import chatgame.event.ChatGameWinEvent;
import chatgame.event.handler.EndEventHandler;
import chatgame.event.listener.ChatGameEndListener;
import chatgame.event.listener.ChatGameLoseListener;
import chatgame.event.listener.ChatGameWinListener;
import chatgame.letter.LetterGame;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

public class ChatGameEvents implements ChatGameWinListener,
		ChatGameLoseListener, ChatGameEndListener {

	@Override
	public void onChatGameLose(ChatGameLoseEvent event) {
		
		ChatGame chatGame = event.getChatGame();
		
		EndEventHandler.fireEvent(new ChatGameEndEvent(chatGame));
		
	}

	@Override
	public void onChatGameWin(ChatGameWinEvent event) {
		
		ChatGame chatGame = event.getChatGame();
		Player winner = event.getWinner();
		
		ChatHelper.broadcastGreenMessage(winner.getName()
				+ " won " + chatGame.getName() + "!");
		
		EndEventHandler.fireEvent(new ChatGameEndEvent(chatGame));
		
	}
	
	@Override
	public void onChatGameEnd (ChatGameEndEvent event) {
		
		ChatGame chatGame = event.getChatGame();

		chatGame.stop();

		if (chatGame instanceof LetterGame) {
			LetterGame letterGame = (LetterGame) chatGame;
			ChatHelper.broadcastYellowMessage(chatGame.getName() + " has " +
					"ended with a total of " + letterGame.getGuesses() + " " +
					"guesses.");
			return;
		}

		ChatHelper.broadcastRedMessage
				(chatGame.getName() + " has ended.");
		
	}
	
}

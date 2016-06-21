package chatgame.letter;

import java.util.Random;

import org.bukkit.entity.Player;

import chatgame.TurnBasedChatGame;
import chatgame.event.ChatGameEndEvent;
import chatgame.event.ChatGameWinEvent;
import chatgame.event.TurnBasedChatEvent;
import chatgame.event.handler.EndEventHandler;
import chatgame.event.handler.WinEventHandler;
import chatgame.event.listener.TurnBasedChatListener;
import exceptions.EmptyQueueException;
import utilities.ChatHelper;

public class LetterGame extends TurnBasedChatGame implements
		TurnBasedChatListener {

	private char currentLetter;
	private int guesses;
	
	private final String alphabet = 
			"abcdefghijklmnopqrstuvwxyz";
	
	public LetterGame() {
		super("Guess The Letter", 1, 1, 60);
	}

	@Override
	public void start() {
		super.start();
		
		int index = new Random()
		.nextInt(alphabet.length());
		
		currentLetter = alphabet.charAt(index);
		
		System.out.println("The letter is " + currentLetter);
		
		ChatHelper.broadcastYellowMessage(getName() + " has started.");
		ChatHelper.broadcastYellowMessage("Whoever guesses the letter first wins!");
	}

	@Override
	public void stop() {
		super.stop();
		
		ChatHelper.broadcastYellowMessage(getName() + " has ended"
				+ " with a total of " + guesses + " guesses.");
		
		guesses = 0;
		
	}

	@Override
	public void onTurnBasedChat(TurnBasedChatEvent event) {
		Player player = null;
		try {
			player = getNextPlayer();
		} catch (EmptyQueueException e) {
			EndEventHandler.fireEvent(new ChatGameEndEvent(this));
		}
		
		System.out.println("The next player is " + player.getName() + ".");
		
		char guessedChar = message.charAt(0);
		
		guesses++;
		
		if (guessedChar != currentLetter) {
			ChatHelper.sendRedMessage(player, "Nope!");
			System.out.println("Looks like he guessed wrong.");
		}
		
		else WinEventHandler.fireEvent(new ChatGameWinEvent(this, player));
	}
	
}

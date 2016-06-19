package chatgame.letter;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatgame.TurnBasedChatGame;
import chatgame.event.ChatGameEndEvent;
import chatgame.event.ChatGameWinEvent;
import chatgame.event.handler.EndEventHandler;
import chatgame.event.handler.WinEventHandler;
import exceptions.EmptyQueueException;
import utilities.ChatHelper;

public class LetterGame extends TurnBasedChatGame {

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
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
		
		if (!getPlayers().contains(player)) {
			System.out.println("Returning");
			return;
		}
		
		Player player = null;
		try {
			player = getNextPlayer();
		} catch (EmptyQueueException e) {
			EndEventHandler.fireEvent(new ChatGameEndEvent(this));
		}
		
		char guessedChar = message.charAt(0);
		
		guesses++;
		
		if (guessedChar != currentLetter) {
			ChatHelper.sendRedMessage(player, "Nope!");
//			removePlayer(player);
		}
		
		else WinEventHandler.fireEvent(new ChatGameWinEvent(this, player));
		
	}
	
}

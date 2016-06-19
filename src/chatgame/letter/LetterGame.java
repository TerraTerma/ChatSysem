package chatgame.letter;

import java.util.Random;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatgame.ChatGame;
import chatgame.event.ChatGameWinEvent;
import chatgame.event.handler.WinEventHandler;
import utilities.ChatHelper;
import utilities.PlayerBooleanArray;

public class LetterGame extends ChatGame {

	private char currentLetter;
	private int guesses;
	
	private final String alphabet = 
			"abcdefghijklmnopqrstuvwxyz";
	
	private PlayerBooleanArray booleanPair;
	
	public LetterGame() {
		super("Guess The Letter", 1, 60);
		
		booleanPair = new PlayerBooleanArray(false);
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
		
		booleanPair.clear();
	}

	@Override
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
		
		if (!booleanPair.contains(player)) booleanPair.add(player);
		
		if (booleanPair.isTrue(player)) {
			ChatHelper.sendRedMessage(player, "You can't guesse again.");
			return;
		}
		
		char guessedChar = message.charAt(0);
		
		guesses++;
		
		if (guessedChar != currentLetter) {
			ChatHelper.sendRedMessage(player, "Nope!");
			if (booleanPair.isFalse(player)) booleanPair.toggle(player);
		}
		
		else WinEventHandler.fireEvent(new ChatGameWinEvent(this, player));
		
	}
	
}

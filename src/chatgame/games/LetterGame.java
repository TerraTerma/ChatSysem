package chatgame.games;

import java.util.Random;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import main.ChatHelper;

public class LetterGame extends ChatGame {

	private char currentLetter;
	private int guesses;
	
	private final String alphabet = 
			"abcdefghijklmnopqrstuvwxyz";
	
	public LetterGame() {
		super("Guess The Letter", 2, 60);
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
		
		char guessedChar = message.charAt(0);
		
		guesses++;
		
		if (guessedChar != currentLetter)
			ChatHelper.sendRedMessage(player, "Nope!");
		
		else {
			ChatHelper.broadcastGreenMessage(player.getName()
					+ " guessed right!");
			stop();
		}
		
	}
	
}

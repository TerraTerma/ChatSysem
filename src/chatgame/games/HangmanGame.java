package chatgame.games;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatgame.TurnBasedChatGame;
import chatgame.configs.HangmanGameConfiguration;
import main.ChatHelper;

public class HangmanGame extends TurnBasedChatGame {

	private List<String> phrases;
	private String currentPhrase;
	
	private char[] phraseChars;
	private char[] correctChars;
	private char[] guessedChars;
	
	private final int tries = 5;
	private int currentTries;
	
	private HangmanGameConfiguration hangmanGameConfiguration;
	
	public HangmanGame() {
		super("Hangman", 1, 120);
		
		hangmanGameConfiguration = new HangmanGameConfiguration();
		phrases = new ArrayList<>
		(hangmanGameConfiguration.getPhrases());
	}
	
	@Override
	public void start () {
		super.start();
		
		currentTries = tries;
		
		currentPhrase = phrases.get
				((int) Math.random() * phrases.size());

		int length = currentPhrase.length();
		
		phraseChars = new char[length];
		correctChars = new char[length];
		currentPhrase.getChars(0, length, phraseChars, 0);
		
		System.out.println("The current phrase is " + currentPhrase);
		
		ChatHelper.broadcastPinkMessage(getName() + " has started.");
	}
	
	@Override
	public void stop () {
		super.stop();
		
		ChatHelper.broadcastPinkMessage(getName() + " has ended.");
	}

	@Override
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
	
		//TODO Finish hangman game.
		
		char typedChar = message.charAt(0);
		
		for (int i = 0; i < phraseChars.length; i++) {
			if (typedChar == phraseChars[i]) {
				correctChars[i] = typedChar;
			}
		}
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < correctChars.length; i++)
			if (correctChars[i] != 0)
				builder.append(correctChars[i]);
			else builder.append("_");
		
		sendAll (builder.toString());
	}

}

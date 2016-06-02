package chatgame.games;

import java.util.List;
import java.util.Random;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatgame.configs.ReactionGameConfiguration;
import main.ChatHelper;

public class ReactionGame extends ChatGame {

	private boolean guessed;
	
	private List<String> words;
	
	private String currentWord;
	
	private ReactionGameConfiguration reactionGameConfiguration;
	
	public ReactionGame() {
		super("Reaction", 1, 60);
		
		reactionGameConfiguration = new ReactionGameConfiguration();
		
		words = reactionGameConfiguration.getWords();
	}
	
	@Override
	public void start() {
		super.start();
		
		ChatHelper.broadcastDarkAquaMessage(getName() + ":");
		
		int wordListSize = words.size();
		
		Random random = new Random();
		int randomIndex = random.nextInt(wordListSize);
		
		currentWord = words.get(randomIndex);
		
		ChatHelper.broadcastAquaMessage("Whoever types the word \"" + currentWord + "\" first wins!");
	}
	
	@Override
	public void stop () {
		super.stop();
		
		if (!guessed)
			ChatHelper.broadcastRedMessage("Nobody typed the word \"" + currentWord + "\" in time.");
		else guessed = false;
		
	}

	@Override
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
		
		if (!message.equalsIgnoreCase(currentWord)) return;
		
			ChatHelper.broadcastGreenMessage(player.getName() + " won the reaction!");
			
			guessed = true;
			
			stop();
		
	}
	
}

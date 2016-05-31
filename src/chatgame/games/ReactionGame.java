package chatgame.games;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatgame.ChatGame;
import chatgame.configs.ReactionGameConfiguration;

public class ReactionGame extends ChatGame implements Listener {

	private List<String> words;
	
	private String currentWord;
	
	private ReactionGameConfiguration reactionGameConfiguration;
	
	public ReactionGame() {
		super("Reaction", 1, 30);
		
		reactionGameConfiguration = new ReactionGameConfiguration();
		
		words = reactionGameConfiguration.getWords();
	}
	
	@Override
	protected void start() {
		super.start();
		
		int wordListSize = words.size();
		
		Random random = new Random();
		int randomIndex = random.nextInt(wordListSize);
		
		currentWord = words.get(randomIndex);
		
		Bukkit.broadcastMessage("Say the word " + currentWord + " as fast as you can!");
	}


	@Override @EventHandler
	protected void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
		
		if (message.equalsIgnoreCase(currentWord)) {
			Bukkit.broadcastMessage(player.getName() + " won the reaction!");
			stop();
		}
	}
	
}

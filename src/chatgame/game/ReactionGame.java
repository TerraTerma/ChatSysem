package chatgame.game;

import chatgame.ChatGame;
import chatgame.ReloadableChatGame;
import chatgame.event.ChatGameHandler;
import chatgame.event.ChatGameWinEvent;
import configuration.ReactionGameConfiguration;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import utilities.ChatHelper;
import utilities.ListHelper;

import java.util.List;
import java.util.Random;

public class ReactionGame extends ChatGame implements ReloadableChatGame {

	private boolean guessed;
	
	private List<String> words;
	
	private String currentWord;
    private long startMillis;
    private int seconds;
    private int millis;

	public ReactionGame() {
		super("Reaction", 1, 30);
	}

	@Override
	public void reload () {
		words = (List<String>) ReactionGameConfiguration.WORDS.getValue();
	}

	@Override
	public void start() {
		super.start();
		
		ChatHelper.broadcastDarkAquaMessage(getName() + ":");
		
		int wordListSize = words.size();
		
		currentWord = ListHelper.selectRandom(words);
		
		Random random = new Random();
		int randomIndex = random.nextInt(wordListSize);
		
		currentWord = words.get(randomIndex);
        startMillis = System.currentTimeMillis();
		
		ChatHelper.broadcastAquaMessage("Whoever types the word \"" + currentWord + "\" first wins!");
	}
	
	@Override
	public void stop () {
		super.stop();

		if (!guessed)
			ChatHelper.broadcastRedMessage("Nobody typed the word \"" + currentWord + "\" in time.");
		else guessed = false;
		
	}

	public String getTimeString () {
	    StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(seconds + "." + millis);
        return stringBuilder.toString();
    }

	@Override
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);

        if (!message.equalsIgnoreCase(currentWord)) return;
        guessed = true;
        long reactionTime = System.currentTimeMillis() - startMillis;
        seconds = (int) reactionTime / 1000;
        millis = (int) reactionTime % 1000;
        ChatGameWinEvent chatGameWinEvent = new ChatGameWinEvent(this);
        chatGameWinEvent.setPlayer(event.getPlayer());
        chatGameWinEvent.setTime(getTimeString());
        ChatGameHandler.fireEvent(chatGameWinEvent);
	}
	
}

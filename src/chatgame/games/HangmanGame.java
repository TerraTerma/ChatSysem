package chatgame.games;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatgame.ChatGame;

public class HangmanGame extends ChatGame implements Listener {

	public HangmanGame() {
		super("Hangman", 2, 120);
	}
	
	@Override
	public void start () {
		super.start();
	}

	@Override @EventHandler
	protected void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
	}

}

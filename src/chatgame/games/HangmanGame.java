package chatgame.games;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import main.ChatHelper;

public class HangmanGame extends ChatGame implements Listener {

	public HangmanGame() {
		super("Hangman", 2, 120);
	}
	
	@Override
	public void start () {
		super.start();
		
		ChatHelper.broadcastYellowMessage(getName() + ":");
	}
	
	@Override
	public void stop () {
		super.stop();
		
		ChatHelper.broadcastYellowMessage(getName() + " has ended.");
	}

	@Override @EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
	}

}

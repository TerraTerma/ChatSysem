package games;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ReactionGame extends ChatGame implements Listener {

	String[] words = {
		"testword1",
		"yeahbro",
		"something else"
	};
	
	public ReactionGame() {
		super("Reaction", 2);
	}

	@Override
	@EventHandler
	protected void onPlayerChat(AsyncPlayerChatEvent event) {
		event.getPlayer().sendMessage("You are in a chat game");
	}
	
}

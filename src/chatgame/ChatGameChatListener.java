package chatgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatGameChatListener implements Listener {

	private List<ChatGame> chatGames = new ArrayList<>();
	
	@EventHandler
	public void onPlayerChat (AsyncPlayerChatEvent event) {
		
		Optional<ChatGame> chatGame = chatGames.stream()
		.filter(ChatGame::isRunning)
		.findAny();
		
		if (chatGame.isPresent())
			chatGame.get()
			.onPlayerChat(event);
		
	}
	
	void listenOn (ChatGame chatGame) {
		chatGames.add(chatGame);
	}
	
}

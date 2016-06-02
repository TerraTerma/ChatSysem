package chatgame;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import chatgame.games.ChatGame;
import main.Main;

public class ChatGameRegistry {

	private Main main;
	private List<ChatGame> chatGames;
	
	private ChatGameChatListener chatGameChatListener;
	
	public ChatGameRegistry (Main main) {
		this.main = main;
		chatGames = new ArrayList<>();
		
		chatGameChatListener = new ChatGameChatListener();
	}
	
	public void fillQueue (ChatGameQueue chatGameQueue) {
		chatGames.stream()
		.forEach(e -> chatGameQueue.addGame(e));
	}
	
	public void registerGame (ChatGame chatGame) {
		registerEvents(chatGame, main);
		
		chatGames.add(chatGame);
		chatGameChatListener.listenOn(chatGame);
	}
	
	private void registerEvents (Listener listener, JavaPlugin javaPlugin) {
		main.getServer()
		.getPluginManager()
		.registerEvents(listener, javaPlugin);
	}
	
	public void close () {
		registerEvents(chatGameChatListener, main);
	}
	
}

package chatgame;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

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
		
		HandlerList.unregisterAll(chatGameChatListener);
		
		registerEvents (chatGameChatListener, main);
	}
	
	private void registerEvents (Listener listener, JavaPlugin javaPlugin) {
		main.getServer()
		.getPluginManager()
		.registerEvents(listener, javaPlugin);
	}
	
}

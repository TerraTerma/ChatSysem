package chatgame;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import chatgame.event.handler.TurnBasedChatEventHandler;
import chatgame.event.listener.TurnBasedChatListener;
import main.Main;

public class ChatGameRegistry {

	private static Main main;
	private static List<ChatGame> chatGames;
	
	private static ChatGameChatListener chatGameChatListener;
	
	public ChatGameRegistry (Main main) {
		ChatGameRegistry.main = main;
		chatGames = new ArrayList<>();
		
		chatGameChatListener = new ChatGameChatListener();
	}
	
	public static void fillQueue () {
		chatGames.stream()
		.forEach(ChatGameQueue::addGame);
	}
	
	public static void registerGame (ChatGame chatGame) {
		registerEvents(chatGame, main);
		registerCustomEvents(chatGame);
		
		chatGames.add(chatGame);
		chatGameChatListener.listenOn(chatGame);
		
		HandlerList.unregisterAll(chatGameChatListener);
		
		registerEvents (chatGameChatListener, main);
	}
	
	private static void registerEvents (Listener listener, JavaPlugin javaPlugin) {
		main.getServer()
		.getPluginManager()
		.registerEvents(listener, javaPlugin);
	}
	
	private static void registerCustomEvents (ChatGame chatGame) {
		if (chatGame instanceof TurnBasedChatListener)
			TurnBasedChatEventHandler.addListener
			((TurnBasedChatListener) chatGame);
	}
	
}

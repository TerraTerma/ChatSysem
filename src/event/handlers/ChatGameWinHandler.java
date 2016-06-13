package event.handlers;

import java.util.ArrayList;
import java.util.List;

import event.ChatGameWinEvent;
import event.listeners.ChatGameWinListener;

public class ChatGameWinHandler {

	private static List<ChatGameWinListener> listeners;
	
	public ChatGameWinHandler () {
		listeners = new ArrayList<>();
	}
	
	public static void addListener (ChatGameWinListener winListener) {
		listeners.add(winListener);
	}
	
	public static void removeListener (ChatGameWinListener winListener) {
		listeners.remove(winListener);
	}
	
	public static void fireEvent (ChatGameWinEvent chatGameWinEvent) {
		listeners.stream()
		.forEach(e -> e.onChatGameWin(chatGameWinEvent));
	}
	
}

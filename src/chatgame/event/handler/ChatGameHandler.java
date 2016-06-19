package chatgame.event.handler;

import java.util.ArrayList;
import java.util.List;

import chatgame.event.listener.ChatGameListener;

public class ChatGameHandler {

	private static List<ChatGameListener> listeners = new ArrayList<>();
	
	public static List<ChatGameListener> getListeners () {
		return listeners;
	}
	
	public static void addListener (ChatGameListener listener) {
		listeners.add(listener);
	}
	
	public static void removeListener (ChatGameListener listener) {
		listeners.remove(listener);
	}
	
}

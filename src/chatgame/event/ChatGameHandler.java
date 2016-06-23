package chatgame.event;

import chatgame.event.ChatGameEvent;
import chatgame.event.ChatGameListener;

import java.util.ArrayList;
import java.util.List;

public class ChatGameHandler {

	private static List<ChatGameListener> listeners = new ArrayList<>();

	public static void addListener (ChatGameListener listener) {
		listeners.add(listener);
	}

	public static void fireEvent
			(ChatGameEvent event) {

		listeners.stream().forEach(e -> e.onEventFire(event));

	}

}

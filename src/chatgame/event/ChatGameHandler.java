package chatgame.event;

import java.util.ArrayList;
import java.util.List;

public class ChatGameHandler {

	private static List<ChatGameListener> listeners = new ArrayList<>();

	public static void addListener (ChatGameListener listener) {
		listeners.add(listener);
	}

	public static void fireEvent
			(ChatGameEvent event) {

		listeners.forEach(e -> e.onEventFire(event));

	}

}

package chatgame.event.handler;

import chatgame.event.ChatGameLoseEvent;
import chatgame.event.listener.ChatGameListener;
import chatgame.event.listener.ChatGameLoseListener;

public class LoseEventHandler extends ChatGameHandler {
	
	public static void fireEvent (ChatGameLoseEvent event) {
		for (ChatGameListener listener : getListeners())
			if (listener instanceof ChatGameLoseListener) {
				ChatGameLoseListener chatGameLoseListener;
				chatGameLoseListener  = (ChatGameLoseListener) listener;
				chatGameLoseListener.onChatGameLose(event);
			}
	}
	
}

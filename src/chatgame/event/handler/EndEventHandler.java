package chatgame.event.handler;

import chatgame.event.ChatGameEndEvent;
import chatgame.event.listener.ChatGameEndListener;
import chatgame.event.listener.ChatGameListener;

public class EndEventHandler extends ChatGameHandler {

	public static void fireEvent (ChatGameEndEvent event) {
		for (ChatGameListener listener : getListeners()) {
			if (listener instanceof ChatGameEndListener) {
				ChatGameEndListener endListener;
				endListener = (ChatGameEndListener) listener;
				endListener.onChatGameEnd(event);
			}
		}
	}
	
}

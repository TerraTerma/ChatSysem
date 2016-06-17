package chatgame.event.handler;

import chatgame.event.ChatGameWinEvent;
import chatgame.event.listener.ChatGameListener;
import chatgame.event.listener.ChatGameWinListener;

public class WinEventHandler extends ChatGameHandler {

	public static void fireEvent (ChatGameWinEvent event) {
		for (ChatGameListener listener : getListeners())
			if (listener instanceof ChatGameWinListener) {
				ChatGameWinListener chatGameWinListener;
				chatGameWinListener  = (ChatGameWinListener) listener;
				chatGameWinListener.onChatGameWin(event);
			}
	}
	
}

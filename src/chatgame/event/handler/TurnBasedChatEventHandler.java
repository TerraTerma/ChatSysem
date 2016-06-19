package chatgame.event.handler;

import chatgame.event.TurnBasedChatEvent;
import chatgame.event.listener.ChatGameListener;
import chatgame.event.listener.ChatGameLoseListener;
import chatgame.event.listener.TurnBasedChatListener;

public class TurnBasedChatEventHandler extends ChatGameHandler {

	public static void fireEvent (TurnBasedChatEvent event) {
		for (ChatGameListener listener : getListeners())
			if (listener instanceof TurnBasedChatListener) {
				TurnBasedChatListener turnBasedChatListener;
				turnBasedChatListener  = (TurnBasedChatListener) listener;
				turnBasedChatListener.onTurnBasedChat(event);
			}
	}
	
}

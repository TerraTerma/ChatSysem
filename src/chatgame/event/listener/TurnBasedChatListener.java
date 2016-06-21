package chatgame.event.listener;

import chatgame.event.TurnBasedChatEvent;

public interface TurnBasedChatListener extends ChatGameListener {

	void onTurnBasedChat (TurnBasedChatEvent event);
	
}

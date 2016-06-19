package chatgame.event.listener;

import chatgame.event.TurnBasedChatEvent;

public interface TurnBasedChatListener extends ChatGameListener {

	public void onTurnBasedChat (TurnBasedChatEvent event);
	
}

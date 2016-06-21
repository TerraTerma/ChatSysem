package chatgame.event.listener;

import chatgame.event.ChatGameEndEvent;

public interface ChatGameEndListener extends ChatGameListener {

	void onChatGameEnd (ChatGameEndEvent event);
	
}

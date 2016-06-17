package chatgame.event.listener;

import chatgame.event.ChatGameEndEvent;

public interface ChatGameEndListener extends ChatGameListener {

	public void onChatGameEnd (ChatGameEndEvent event);
	
}

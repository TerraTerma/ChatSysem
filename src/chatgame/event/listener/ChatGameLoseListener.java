package chatgame.event.listener;

import chatgame.event.ChatGameLoseEvent;

public interface ChatGameLoseListener extends ChatGameListener {

	void onChatGameLose (ChatGameLoseEvent event);
	
}

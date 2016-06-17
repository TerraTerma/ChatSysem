package chatgame.event.listener;

import chatgame.event.ChatGameLoseEvent;

public interface ChatGameLoseListener extends ChatGameListener {

	public void onChatGameLose (ChatGameLoseEvent event);
	
}

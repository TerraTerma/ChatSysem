package chatgame.event.listener;

import chatgame.event.ChatGameWinEvent;

public interface ChatGameWinListener extends ChatGameListener {

	void onChatGameWin (ChatGameWinEvent event);
	
}

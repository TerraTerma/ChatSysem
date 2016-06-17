package chatgame.event.listener;

import chatgame.event.ChatGameWinEvent;

public interface ChatGameWinListener extends ChatGameListener {

	public void onChatGameWin (ChatGameWinEvent event);
	
}

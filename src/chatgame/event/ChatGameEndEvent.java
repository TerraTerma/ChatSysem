package chatgame.event;

import chatgame.ChatGame;

public class ChatGameEndEvent {

	private ChatGame chatGame;
	
	public ChatGameEndEvent (ChatGame chatGame) {
		this.chatGame = chatGame;
	}
	
	public ChatGame getChatGame () {
		return chatGame;
	}
	
}

package chatgame.event;

import chatgame.ChatGame;

public class ChatGameEndEvent extends ChatGameEvent {

	private ChatGame chatGame;
	
	public ChatGameEndEvent (ChatGame chatGame) {
		super (chatGame);
		this.chatGame = chatGame;
	}
	
	public ChatGame getChatGame () {
		return chatGame;
	}
	
}

package event;

import org.bukkit.entity.Player;

import chatgame.ChatGame;

public class ChatGameWinEvent {

	private ChatGame chatGame;
	private Player player;

	public ChatGameWinEvent () {}
	
	public ChatGameWinEvent (Player player) {
		this.player = player;
	}
	
	public ChatGameWinEvent (Player player, ChatGame chatGame) {
		this.player = player;
		this.chatGame = chatGame;
	}
	
	public void setChatGame(ChatGame chatGame) {
		this.chatGame = chatGame;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer () {
		return player;
	}
	
	public ChatGame getChatGame () {
		return chatGame;
	}

}

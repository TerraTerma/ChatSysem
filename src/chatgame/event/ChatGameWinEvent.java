package chatgame.event;

import org.bukkit.entity.Player;

import chatgame.ChatGame;

public class ChatGameWinEvent extends ChatGameEndEvent {

	private Player winner;

	public ChatGameWinEvent (ChatGame chatGame, Player winner) {
		super (chatGame);
		this.winner = winner;
	}

	public Player getWinner () {
		return winner;
	}
	
}

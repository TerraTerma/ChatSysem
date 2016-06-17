package chatgame.event;

import org.bukkit.entity.Player;

import chatgame.ChatGame;

public class ChatGameLoseEvent extends ChatGameEndEvent {

	private Player loser;
	
	public ChatGameLoseEvent (ChatGame chatGame, Player loser) {
		super (chatGame);
		this.loser = loser;
	}
	
	public Player getLoser () {
		return loser;
	}
	
}

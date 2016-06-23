package chatgame.event;

import chatgame.ChatGame;
import org.bukkit.entity.Player;

public class TurnBasedChatEvent extends ChatGameEvent {

	private Player player;
	private String message;
	
	public TurnBasedChatEvent (ChatGame chatGame, Player player, String message) {
		super (chatGame);
		this.player = player;
		this.message = message;
	}
	
	public Player getPlayer () {
		return player;
	}
	
	public String getMessage () {
		return message;
	}
	
}

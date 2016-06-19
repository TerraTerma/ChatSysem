package chatgame.event;

import org.bukkit.entity.Player;

public class TurnBasedChatEvent {

	private Player player;
	private String message;
	
	public TurnBasedChatEvent (Player player, String message) {
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

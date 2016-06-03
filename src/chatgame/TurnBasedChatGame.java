package chatgame;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import utilities.ChatHelper;

public class TurnBasedChatGame extends ChatGame {

	private List<Player> joinedPlayers;
	
	public TurnBasedChatGame (String name, int minPlayers, int maxTime) {
		super (name, minPlayers, maxTime);
		
		joinedPlayers = new ArrayList<>();
	}
	
	@Override
	public void start () {
		super.start();
		
		ChatHelper.broadcastGrayMessage
		(getName() + " is starting. Type \"join\" to join!");
	}
	
	@Override
	public void stop () {
		super.stop();
		joinedPlayers.clear();
	}
	
	public void addPlayer (Player player) {
		if (!(joinedPlayers.contains(player)))
			joinedPlayers.add(player);
		
		ChatHelper.sendGreenMessage (player, 
				"You joined " + getName());
	}
	
	public void sendAll (String message) {
		joinedPlayers.stream()
		.forEach(e -> e.sendMessage(message));
	}
	
	//TODO Make this into an event handler.
	public void onPlayerJoin () {}
	
	@Override
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
		
		if (message.equalsIgnoreCase("join"))
			addPlayer(player);
	}
	
}

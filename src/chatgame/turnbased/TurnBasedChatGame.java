package chatgame.turnbased;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatgame.ChatGame;
import utilities.ChatHelper;

public abstract class TurnBasedChatGame extends ChatGame {

	private TurnList turnList;
	
	public TurnBasedChatGame (String name, int turns, int minPlayers, int maxTime) {
		super (name, minPlayers, maxTime);
		
		turnList = new TurnList (turns);
	}
	
	public List<Player> getJoinedPlayers () {
		return turnList.getPlayers();
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
		turnList.clear();
	}
	
	public void addPlayer (Player player) {
		turnList.safeAdd(player);
		
		ChatHelper.sendGreenMessage (player, 
				"You joined " + getName());
	}
	
	public void sendAll (ChatColor chatColor, String message) {
		turnList.getPlayers().stream()
		.forEach(e -> e.sendMessage(chatColor + message));
	}
	
	@Override
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
		
		if (message.equalsIgnoreCase("join"))
			addPlayer(player);
	}
	
}

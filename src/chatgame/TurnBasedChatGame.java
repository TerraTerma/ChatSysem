package chatgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatgame.event.TurnBasedChatEvent;
import chatgame.event.handler.TurnBasedChatEventHandler;
import exceptions.CorruptedListException;
import exceptions.EmptyQueueException;
import utilities.ChatHelper;

public abstract class TurnBasedChatGame extends ChatGame {

	private Queue<Player> playerQueue;
	private List<Player> players;
	
	private final int turns;
	private int currentTurns;
	
	public TurnBasedChatGame (String name, int turns, int minPlayers, int maxTime) {
		super (name, minPlayers, maxTime);
		
		this.turns = turns;
		
		playerQueue = new LinkedList<>();
		players = new ArrayList<>();
	}
	
	public Collection<Player> getPlayers () {
		return playerQueue;
	}
	
	public Collection<Player> getAllPlayers () {
		return players;
	}
	
	public Player getNextPlayer () throws EmptyQueueException {
		
		Player player = playerQueue.poll();
		
		if (player == null) {
			currentTurns--;
			
			if (currentTurns == 0)
				throw new EmptyQueueException();
			
			refill();
		}
		
		return player;
	}
	
	private void refill () {
		playerQueue.addAll(players);
	}
	
	@Override
	public void start () {
		super.start();
		
		currentTurns = turns;
		
		ChatHelper.broadcastGrayMessage
		(getName() + " is starting. Type \"join\" to join!");
	}
	
	@Override
	public void stop () {
		super.stop();
		playerQueue.clear();
		players.clear();
	}
	
	public void addPlayer (Player player) {
		if (!players.contains(player))
			players.add(player);
		
		if (!playerQueue.contains(player))
			playerQueue.add(player);
		
		try {
			checkSize();
		} catch (CorruptedListException e) {
			e.printStackTrace();
		}
		
		ChatHelper.sendGreenMessage (player, 
				"You joined " + getName());
	}
	
	public void removePlayer (Player player) {
		players.remove(player);
		playerQueue.remove(player);
		
		try {
			checkSize();
		} catch (CorruptedListException e) {
			e.printStackTrace();
		}
		
		ChatHelper.sendRedMessage(player, "You've been removed from " + getName() + ".");
	}
	
	protected void sendAll (ChatColor chatColor, String message) {
		players.stream()
		.forEach(e -> e.sendMessage(chatColor + message));
	}
	
	@Override
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		super.onPlayerChat(event);
		
		if (players.contains(player)) {
			TurnBasedChatEventHandler.fireEvent
			(new TurnBasedChatEvent(player, message));
			
			System.out.println("Fired event.");
		}
		
		if (message.equalsIgnoreCase("join"))
			addPlayer(player);
	}
	
	private void checkSize () throws CorruptedListException {
		if (players.size() != playerQueue.size())
			throw new CorruptedListException();
	}
	
}

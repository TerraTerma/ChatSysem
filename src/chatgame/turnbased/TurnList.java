package chatgame.turnbased;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.bukkit.entity.Player;

public class TurnList {

	private final List<Player> players;
	private Queue<Player> playerQueue;
	
	private final int turns;
	private int currentTurn;
	
	public TurnList (int turns) {
		this.turns = turns;
		players = new ArrayList<>();
		playerQueue = new LinkedList<>();
	}
	
	public TurnList (int turns, List<Player> players) {
		this (turns);
		players.addAll(players);
		playerQueue.addAll(players);
	}
	
	public List<Player> getPlayers () {
		return players;
	}
	
	public int getTurns () {
		return turns;
	}
	
	public int getCurrentTurn () {
		return currentTurn;
	}

	public boolean hasNext () {
		return playerQueue.peek() != null;
	}
	
	public Player next () throws NullPointerException {
		
		Player player = playerQueue.poll();
		
		if (player == null)
			throw new NullPointerException();
		
		if (!hasNext())
			nextIteration();
		
		return player;
	}
	
	public Player peekNext () throws NullPointerException {
		
		Player player = playerQueue.peek();
		
		if (player == null)
			throw new NullPointerException();
		
		return player;
	}
	
	public void add (Player player) {
		playerQueue.add(player);
	}
	
	public void safeAdd (Player player) {
		if (!playerQueue.contains(player))
			playerQueue.add(player);
	}
	
	public void remove (Player player) {
		playerQueue.remove(player);
	}
	
	public void clear () {
		players.clear();
		playerQueue.clear();
		currentTurn = 0;
	}
	
	private void nextIteration () {
		playerQueue.addAll(players);
		currentTurn++;
	}
	
}

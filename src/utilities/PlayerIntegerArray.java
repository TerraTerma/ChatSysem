package utilities;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class PlayerIntegerArray {

	private Map<Player, Integer> pairs;
	
	private final int startValue;
	
	public PlayerIntegerArray (int startValue) {
		this.startValue = startValue;
		
		pairs = new HashMap<>();
	}
	
	public int getStartValue() {
		return startValue;
	}
	
	public int get (Player player) {
		return pairs.get(player);
	}
	
	public boolean contains (Player player) {
		return pairs.containsKey(player);
	}
	
	public void add (Player player) {
		pairs.put(player, startValue);
	}
	
	public void remove (Player player) {
		pairs.remove(player);
	}
	
	public void increment (Player player) {
		int value = pairs.get(player);
		pairs.put(player, ++value);
	}
	
	public void increment (Player player, int amount) {
		int value = pairs.get(player) + amount;
		pairs.put(player, value);
	}
	
	public void decrement (Player player) {
		int value = pairs.get(player);
		pairs.put(player, --value);
	}
	
	public void decrement (Player player, int amount) {
		int value = pairs.get(player) - amount;
		pairs.put(player, value);
	}
	
	public void clear () {
		pairs.clear();
	}
}

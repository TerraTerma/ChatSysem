package utilities;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class PlayerBooleanArray {

	private Map<Player, Boolean> pairs;
	
	private boolean startBoolean;
	
	public PlayerBooleanArray (boolean startBoolean) {
		this.startBoolean = startBoolean;
		
		pairs = new HashMap<>();
	}
	
	
	
	public boolean getStartBoolean () {
		return startBoolean;
	}
	
	public boolean isFalse (Player player) {
		return pairs.get(player) == false;
	}
	
	public boolean isTrue (Player player) {
		return pairs.get(player) == true;
	}
	
	public boolean contains (Player player) {
		return pairs.containsKey(player);
	}
	
	public void setFalse (Player player) {
		pairs.put(player, false);
	}
	
	public void setTrue (Player player) {
		pairs.put(player, true);
	}
	
	public void toggle (Player player) {
		pairs.put(player, !pairs.get(player));
	}
	
	public void add (Player player) {
		pairs.put(player, startBoolean);
	}
	
	public void remove (Player player) {
		pairs.remove(player);
	}
	
	public void clear () {
		pairs.clear();
	}
	
}

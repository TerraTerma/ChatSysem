package games;

import org.bukkit.entity.Player;

public class ReactionGame extends ChatGame {

	String[] words = {
		"testword1",
		"yeahbro",
		"something else"
	};
	
	public ReactionGame() {
		super("Reaction", 5);
	}

	@Override
	protected void runEvent(Player player, String message) {
		System.out.println("Went through second method");
		player.sendMessage("You are playing the " + name + " game!");
	}
	
}

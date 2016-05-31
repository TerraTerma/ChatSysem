package chatgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;

public class ChatGameQueue {

	private List<ChatGame> chatGames = new ArrayList<>();
	
	private final int intermission = 10;

	public void start() {
		
		GameUtilities.runTimer (new Runnable() {

			Random random = new Random();

			public void run() {

				if (chatGames.stream().anyMatch(e -> e.isRunning())) {
					System.out.println("There is already a chat game running.");
					return;
				}

				ChatGame chatGame = chatGames.get
						(random.nextInt(chatGames.size()));
				
				int playersOnline = Bukkit.getOnlinePlayers().size();
				
				if (playersOnline >= chatGame.getMinimumPlayers())
					chatGame.start();
				else {
					Bukkit.broadcastMessage
					("There aren't enough players for " + chatGame.getName());
					
					return;
				}
				
				System.out.println("Started a new chat game.");

			}
			
		}, 20 * intermission, 20 * intermission);

	}
	
	public void addGame (ChatGame game) {
		chatGames.add(game);
		System.out.println("Registered events for " + game.getName());
	}
	
	public boolean startGame (Class<? extends ChatGame> gameClass) {
		
		if (checkRunningGame()) return true;
		
		chatGames.stream()
		.filter(e -> e.getClass().equals(gameClass))
		.findAny()
		.get()
		.start();
		
		return false;
	}
	
	public boolean checkRunningGame () {
		return chatGames.stream().anyMatch(e -> e.isRunning());
	}
	
}

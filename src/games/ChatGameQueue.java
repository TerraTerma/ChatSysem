package games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatGameQueue {

	private List<ChatGame> chatGames = new ArrayList<>();

	public void start() {
		
		GameUtilities.runTimer(new Runnable() {

			Random random = new Random();

			public void run() {

				if (chatGames.stream().anyMatch(e -> e.isRunning())) {
					System.out.println("There is already a chat game running.");
					return;
				}

				chatGames.get(random.nextInt(chatGames.size())).start();

				System.out.println("Started a new chat game.");

			}
			
		}, 20 * 10, 20 * 10);

	}
	
	public void addGame (ChatGame game) {
		chatGames.add(game);
		System.out.println("Registered events for " + game.getName());
	}
	
}

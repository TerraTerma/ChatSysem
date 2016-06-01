package chatgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;

import exceptions.NotEnoughPlayersException;
import main.ChatHelper;

public class ChatGameQueue {

	private List<ChatGame> chatGames = new ArrayList<>();
	
	private final int intermission = 10;

	public void start() {
		
		ChatGameHelper.runTimer (new Runnable() {

			Random random = new Random();

			public void run() {

				if (checkRunningGame()) return;

				ChatGame chatGame = chatGames.get
						(random.nextInt(chatGames.size()));
				
				try {
					
					startGame (chatGame);
					
				} catch (NotEnoughPlayersException e) {
					
					ChatHelper.broadcastRedMessage("There aren't enough players for " + chatGame.getName());
					
				}
				
			}
			
		}, 20 * intermission, 20 * intermission);

	}
	
	public void addGame (ChatGame game) {
		chatGames.add(game);
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
	
	public void startGame (ChatGame chatGame) throws NotEnoughPlayersException {
		
		int playersOnline = Bukkit.getOnlinePlayers().size();
	
		if (playersOnline < chatGame.getMinimumPlayers())
			throw new NotEnoughPlayersException();
		
		chatGame.start();
	}
	
	public boolean checkRunningGame () {
		return chatGames.stream().anyMatch(e -> e.isRunning());
	}
	
}

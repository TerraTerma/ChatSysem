package chatgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.bukkit.Bukkit;

import exceptions.NotEnoughPlayersException;
import utilities.ChatHelper;

public class ChatGameQueue {

	private static List<ChatGame> chatGames = new ArrayList<>();
	
	private static ChatGameIntermission chatGameIntermission = new
			ChatGameIntermission(10);

	private static IntermissionScheduler intermissionScheduler = new
			IntermissionScheduler();

	public static List<ChatGame> getChatGames () {
		return chatGames;
	}
	
	public static ChatGameIntermission getChatGameIntermission () {
		return chatGameIntermission;
	}

	public static void startQueue() {
		intermissionScheduler.beginMonitor();
	}
	
	public static void addGame (ChatGame game) {
		chatGames.add(game);
	}

	public static boolean forceStartGame (String name) {
		Optional<ChatGame> chatGame = chatGames.stream()
				.filter(e -> e.getName().equalsIgnoreCase(name))
				.findAny();

		if (chatGame.isPresent()) {
			stopRunningGame();
			chatGame.get().start();
			return true;
		}

		return false;
	}

	public static boolean forceStartGame (Class<? extends ChatGame> gameClass) {

		stopRunningGame();

		Optional<ChatGame> game = chatGames.stream()
		.filter(e -> e.getClass().equals(gameClass))
		.findAny();

		if (game.isPresent()) {
			game.get().start();
			return true;
		}

		return false;
	}
	
	public static void startGame (ChatGame chatGame) throws NotEnoughPlayersException {
		
		int playersOnline = Bukkit.getOnlinePlayers().size();
	
		if (playersOnline < chatGame.getMinimumPlayers())
			throw new NotEnoughPlayersException();
		
		chatGame.start();
	}
	
	public static void startRandomGame () {

		stopRunningGame();

		Random random = new Random ();

		ChatGame chatGame = chatGames.get
				(random.nextInt(chatGames.size()));

		try {
			startGame (chatGame);
		} catch (NotEnoughPlayersException e) {
			ChatHelper.broadcastRedMessage
			("There aren't enough players for " + chatGame.getName());
		}
		
	}
	
	public static Optional<ChatGame> getRunningGame() {
		return chatGames.stream()
				.filter(e -> e.isRunning())
				.findAny();
	}

	public static void stopRunningGame () {
		Optional<ChatGame> chatGame = getRunningGame();
		if (chatGame.isPresent()) chatGame.get().stop();
	}
	
}

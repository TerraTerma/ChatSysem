package chatgame;

import exceptions.NotEnoughPlayersException;
import org.bukkit.Bukkit;
import utilities.ChatHelper;
import utilities.ListHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChatGameQueue {

	private static List<ChatGame> chatGames = new ArrayList<>();
	
	private static ChatGameIntermission chatGameIntermission = new
			ChatGameIntermission(300);

	private static IntermissionScheduler intermissionScheduler = new
			IntermissionScheduler();

	static List<ChatGame> getChatGames () {
		return chatGames;
	}
	
	static ChatGameIntermission getChatGameIntermission () {
		return chatGameIntermission;
	}

	public static void startQueue() {
		intermissionScheduler.beginMonitor();
	}
	
	static void addGame (ChatGame game) {
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
	
	private static void startGame (ChatGame chatGame) throws
			NotEnoughPlayersException {
		
		int playersOnline = Bukkit.getOnlinePlayers().size();
	
		if (playersOnline < chatGame.getMinimumPlayers())
			throw new NotEnoughPlayersException();
		
		chatGame.start();
	}
	
	public static void startRandomGame () {

		stopRunningGame();

		ChatGame chatGame;
		chatGame = ListHelper.selectRandom(chatGames);

		try {
			startGame (chatGame);
		} catch (NotEnoughPlayersException e) {
			ChatHelper.broadcastRedMessage ("There aren't enough players for " +
					chatGame.getName());
		}
		
	}
	
	public static Optional<ChatGame> getRunningGame() {
		return chatGames.stream()
				.filter(ChatGame::isRunning)
				.findAny();
	}

	private static void stopRunningGame () {
		Optional<ChatGame> chatGame = getRunningGame();
		if (chatGame.isPresent()) chatGame.get().stop();
	}
	
}

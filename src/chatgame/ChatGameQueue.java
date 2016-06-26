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

	public static List<ChatGame> getChatGames () {
		return chatGames;
	}

	public static Optional<ChatGame> getChatGame (String name) {
		return chatGames.stream()
						.filter(e -> e.getName().equalsIgnoreCase(name))
						.findAny();
	}
	
	static ChatGameIntermission getChatGameIntermission () {
		return chatGameIntermission;
	}

	public static void startQueue() {
		intermissionScheduler.beginMonitor();
	}
	
	public static boolean addGame (ChatGame game) {
		if (chatGames.contains(game)) return false;
		chatGames.add(game);
		return true;
	}

	public static void removeGame (ChatGame chatGame) {
		Optional<ChatGame> chatGameOptional =
				chatGames.stream()
						 .filter(e -> e.equals(chatGame))
						 .findAny();

		if (chatGameOptional.isPresent()) {
			ChatGame game = chatGameOptional.get();
			chatGames.remove(game);
		}

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

	public static void reloadGames () {
		chatGames.forEach(e ->{
			if (e instanceof ReloadableChatGame)
				((ReloadableChatGame) e).reload();
		});
	}
	
}

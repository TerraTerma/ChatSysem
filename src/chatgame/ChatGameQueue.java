package chatgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;

import exceptions.NotEnoughPlayersException;
import utilities.ChatHelper;

public class ChatGameQueue {

	private List<ChatGame> chatGames = new ArrayList<>();
	
	private ChatGameIntermission chatGameIntermission;
	private IntermissionScheduler intermissionScheduler;
	
	public ChatGameQueue () {
		chatGameIntermission = new ChatGameIntermission(this, 10);
		intermissionScheduler = new IntermissionScheduler(this);
	}

	public List<ChatGame> getChatGames () {
		return chatGames;
	}
	
	public ChatGameIntermission getChatGameIntermission () {
		return chatGameIntermission;
	}
	
	public void startQueue() {
		intermissionScheduler.beginMonitor();
	}
	
	public void addGame (ChatGame game) {
		chatGames.add(game);
	}
	
	public boolean forceStartGame (Class<? extends ChatGame> gameClass) {
		
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
	
	public void startRandomGame () {
		
		Random random = new Random ();
		
		ChatGame chatGame = chatGames.get
				(random.nextInt(chatGames.size()));
		
		try {
			startGame (chatGame);
		} catch (NotEnoughPlayersException e) {
			ChatHelper.broadcastRedMessage("There aren't enough players for " + chatGame.getName());
		}
		
	}
	
	public boolean checkRunningGame () {
		return chatGames.stream().anyMatch(e -> e.isRunning());
	}
	
}

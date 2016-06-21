package main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import chatgame.ChatGame;
import chatgame.event.ChatGameEndEvent;
import chatgame.event.ChatGameLoseEvent;
import chatgame.event.ChatGameWinEvent;
import chatgame.event.handler.EndEventHandler;
import chatgame.event.listener.ChatGameEndListener;
import chatgame.event.listener.ChatGameLoseListener;
import chatgame.event.listener.ChatGameWinListener;
import logan.reward_api.main.Reward;
import logan.reward_api.main.RewardStore;
import logan.reward_api.main.RewardType;
import utilities.ChatHelper;

public class ChatGameEvents implements ChatGameWinListener, ChatGameLoseListener, ChatGameEndListener {

	@Override
	public void onChatGameLose(ChatGameLoseEvent event) {
		
		ChatGame chatGame = event.getChatGame();
		
		EndEventHandler.fireEvent(new ChatGameEndEvent(chatGame));
		
	}

	@Override
	public void onChatGameWin(ChatGameWinEvent event) {
		
		ChatGame chatGame = event.getChatGame();
		Player winner = event.getWinner();
		
		ChatHelper.broadcastGreenMessage(winner.getName()
				+ " won " + chatGame.getName() + "!");
		
//		winner.sendMessage(ChatColor.LIGHT_PURPLE
//				+ "Break a block to get your reward.");
//
//		Reward reward = new Reward(winner)
//				.setAmount(8)
//				.setDisplayName(ChatColor.YELLOW + "ChatGame Reward")
//				.setMaterial(Material.DIRT)
//				.setType(RewardType.MINED);
//
//		RewardStore.put(reward);
		
		EndEventHandler.fireEvent(new ChatGameEndEvent(chatGame));
		
	}
	
	@Override
	public void onChatGameEnd (ChatGameEndEvent event) {
		
		ChatGame chatGame = event.getChatGame();
		
		chatGame.stop();
		
		ChatHelper.broadcastRedMessage
		(chatGame.getName() + " has ended.");
		
	}
	
}

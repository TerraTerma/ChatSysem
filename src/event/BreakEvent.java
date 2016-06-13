package event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import logan.reward_api.main.NoRewardException;
import logan.reward_api.main.Reward;
import logan.reward_api.main.RewardStore;
import utilities.ChatHelper;

public class BreakEvent implements Listener {

	@EventHandler
	public void onBlockBreak (BlockBreakEvent event) {
		
		Player player = event.getPlayer();
		
//		Reward reward;
//		
//		try {
//			reward = RewardStore.grab(player);
//			ChatHelper.sendPinkMessage(player, "You have a reward!");
//		} catch (NoRewardException e) {
//			return;
//		}
		
		//TODO Figure out way to make block drop the reward
		
//		player.getInventory()
//		.addItem(reward.getItemStack());
		
	}
	
}

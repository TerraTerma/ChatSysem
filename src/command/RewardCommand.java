package command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import logan.reward_api.main.Reward;
import logan.reward_api.main.RewardStore;
import utilities.ChatHelper;

public class RewardCommand implements ChatSystemCommand {

	@Override
	public void run (Player player, String[] args) {
		
		ChatHelper.sendGrayMessage(player, "Running rewards command.");
		
		Reward reward = new Reward(player)
				.setMaterial(Material.DIAMOND)
				.setAmount(2)
				.setDisplayName(ChatColor.BLUE + "You got a sexy diamond.")
				.setLore("This is one amazing diamond..", "Don't you think?");
		
		RewardStore.put(reward);
		
		ChatHelper.sendGrayMessage(player, "There has been a reward reserved for you!");
		
	}

}

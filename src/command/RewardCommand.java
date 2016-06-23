package command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import logan.reward_api.main.Reward;
import logan.reward_api.main.RewardStore;
import utilities.ChatHelper;

public class RewardCommand extends ChatSystemCommand {

	public RewardCommand() {
		super("cgreward");
	}

	@Override
	public void run (CommandSender sender, Object... args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player.");
			return;
		}

		ChatHelper.sendGrayMessage(sender, "Running rewards command.");

		Reward reward = new Reward((Player) sender)
				.setMaterial(Material.DIAMOND)
				.setAmount(2)
				.setDisplayName(ChatColor.BLUE + "You got a sexy diamond.")
				.setLore("This is one amazing diamond..", "Don't you think?");
		
		RewardStore.put(reward);
		
		ChatHelper.sendGrayMessage(sender, "There has been a reward reserved for you!");
		
	}

}

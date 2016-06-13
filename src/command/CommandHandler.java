package command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

	private RewardCommand rewardCommand = new RewardCommand();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player;
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player.");
			return true;
		}
		
		player = (Player) sender;
		
		if (label.equalsIgnoreCase("cgreward"))
			rewardCommand.run(player, args);
		
		return false;
	}
	
}

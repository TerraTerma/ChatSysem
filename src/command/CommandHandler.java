package command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

	private ChatSystemCommand[] commands = {
			new RewardCommand(),
			new SkipCommand(),
			new ForceCommand()
	};
	
	@Override
	public boolean onCommand (CommandSender sender, Command command, String
			label, String[] args) {

		for (ChatSystemCommand chatSystemCommand : commands) {

			String name = chatSystemCommand.getName();

			if (label.equalsIgnoreCase(name))
				chatSystemCommand.run(sender, args);

		}
		
		return false;
	}
	
}

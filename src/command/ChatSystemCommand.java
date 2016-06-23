package command;

import org.bukkit.command.CommandSender;

abstract class ChatSystemCommand {

	private String name;

	ChatSystemCommand (String name) {
		this.name = name;
	}

	String getName () {
		return name;
	}

	abstract void run (CommandSender sender, String... args);

}

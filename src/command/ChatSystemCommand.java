package command;

import org.bukkit.command.CommandSender;

public abstract class ChatSystemCommand {

	private String name;

	ChatSystemCommand (String name) {
		this.name = name;
	}

	String getName () {
		return name;
	}

	abstract boolean run (CommandSender sender, Object... args);

}

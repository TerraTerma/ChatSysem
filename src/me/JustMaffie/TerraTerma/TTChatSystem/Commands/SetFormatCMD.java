package me.JustMaffie.TerraTerma.TTChatSystem.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import TTCore.Entity.Living.Human.Player.TTPlayer;
import TTCore.Mech.DefaultMechs.MessageFormatData;

public class SetFormatCMD implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			TTPlayer player = TTPlayer.getPlayer((Player) sender);
			MessageFormatData data = player.getSingleData(MessageFormatData.class).get();
			if (args.length == 0) {
				// DISPLAY HELP
			} else if (args[0].equalsIgnoreCase("staff")) {
				String format = null;
				for (int A = 1; A < args.length; A++) {
					String message = args[A];
					if (format == null) {
						format = message;
					} else {
						format = (format + " " + message);
					}
				}
				data.setStaffChatFormat(format);
				return true;
			} else if (args[0].equalsIgnoreCase("chat")) {
				String format = null;
				for (int A = 1; A < args.length; A++) {
					String message = args[A];
					if (format == null) {
						format = message;
					} else {
						format = (format + " " + message);
					}
				}
				data.setChatFormat(format);
				return true;
			} else {
				String format = null;
				for (int A = 1; A < args.length; A++) {
					String message = args[A];
					if (format == null) {
						format = message;
					} else {
						format = (format + " " + message);
					}
				}
				data.setChatFormat(format);
				return true;
			}
		}
		return false;
	}

}

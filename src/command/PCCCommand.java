package command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utilities.ChatHelper;

public class PCCCommand extends ChatSystemCommand{
    public PCCCommand () {
        super("pcc");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
        for (int i = 0; i < 100; i++)
            sender.sendMessage("");
        sender.sendMessage(ChatHelper.colorText("&2You have cleared your chat."));
    	return true;
    }
}

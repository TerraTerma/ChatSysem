package command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utilities.ChatHelper;

public class PersonalClearChatCommand extends ChatSystemCommand{
    public PersonalClearChatCommand () {
        super("pcc");
    }
    @Override
    boolean run (CommandSender sender, Object... args) {
    	Player player = (Player) sender;
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage("");
        sender.sendMessage(ChatHelper.colorText("&2You have cleared your personal chat."));
    	return true;
    }
}

package command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import configuration.MessageConfiguration;
import utilities.ChatHelper;

public class SiteCommand extends ChatSystemCommand{
    public SiteCommand () {
        super ("site");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
    	sender.sendMessage(ChatHelper.colorText(MessageConfiguration.WEBSITE_FORMAT.getValue().toString()));
        return true;
    }
}

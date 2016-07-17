package command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ClearChatCommand extends ChatSystemCommand {

    public ClearChatCommand () {
        super ("clearchat");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {

            for (int i = 0; i < 100; i++)
                Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "The chat was cleared by " + sender.getName());

        return true;
    }
}

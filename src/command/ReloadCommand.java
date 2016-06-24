package command;

import main.ChatConfig;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends ChatSystemCommand {

    public ReloadCommand () {
        super("csreload");
    }

    @Override
    void run (CommandSender sender, Object... args) {
        ChatConfig.reload();
        sender.sendMessage("Reloaded ChatSystem config...");
    }
}

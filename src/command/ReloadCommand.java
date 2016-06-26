package command;

import configuration.ConfigurationManager;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends ChatSystemCommand {

    public ReloadCommand () {
        super("csreload");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
        ConfigurationManager.reloadConfigurations();
        sender.sendMessage("Reloaded ChatSystem configuration.");
        return true;
    }
}

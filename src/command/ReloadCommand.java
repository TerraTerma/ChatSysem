package command;

import configuration.ConfigurationRegistry;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends ChatSystemCommand {

    public ReloadCommand () {
        super("csreload");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
        ConfigurationRegistry.reloadConfigurations();
        sender.sendMessage("Reloaded ChatSystem configuration.");
        return true;
    }
}

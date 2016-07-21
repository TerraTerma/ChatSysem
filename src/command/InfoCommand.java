package command;

import main.Main;
import org.bukkit.command.CommandSender;
import utilities.ChatHelper;

public class InfoCommand extends ChatSystemCommand {

    private Main main;

    public InfoCommand (Main main) {
        super ("csinfo");
        this.main = main;
    }

    @Override
    boolean run(CommandSender sender, Object... args) {

        String name = main.getName();
        String version = main.getDescription().getVersion();

        ChatHelper.sendYellowMessage(sender, name + " " + version);

        return true;
    }
}

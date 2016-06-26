package command;

import chatgame.ChatGameQueue;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

import java.io.Console;

public class ForceCommand extends ChatSystemCommand {

    public ForceCommand () {
        super("cgforce");
    }

    @Override
    boolean run(CommandSender sender, Object... args) {
        if (args.length == 0) return false;

        String gameName = args[0].toString();
        if (!ChatGameQueue.forceStartGame(gameName))
            ChatHelper.sendAquaMessage(sender, "Couldn't find the game " +
                    gameName + ".");

        return true;
    }

}

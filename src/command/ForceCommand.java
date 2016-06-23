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
    void run(CommandSender sender, Object... args) {

        String gameName;

        if (args.length == 1) gameName = args[0].toString();
        else return;

        if (!ChatGameQueue.forceStartGame(gameName))
            ChatHelper.sendAquaMessage(sender, "Couldn't find the game " +
                    gameName + ".");

    }

}

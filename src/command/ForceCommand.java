package command;

import chatgame.ChatGameQueue;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

import java.io.Console;

class ForceCommand extends ChatSystemCommand {

    ForceCommand () {
        super("cgforce");
    }

    @Override
    void run(CommandSender sender, String... args) {

        String gameName;

        if (args.length == 1) gameName = args[0];
        else return;

        if (!ChatGameQueue.forceStartGame(gameName))
            ChatHelper.sendAquaMessage(sender, "Couldn't find the game " +
                    gameName + ".");

    }

}

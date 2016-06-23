package command;

import chatgame.ChatGameQueue;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

/**
 * Created by Tre on 6/20/2016.
 */
public class SkipCommand extends ChatSystemCommand {

    SkipCommand () {
        super("cgskip");
    }

    @Override
    void run(CommandSender sender, String... args) {

        ChatGameQueue.startRandomGame();

        ChatHelper.sendDarkBlueMessage(sender,
                "Skipped the current chat game.");

    }
}

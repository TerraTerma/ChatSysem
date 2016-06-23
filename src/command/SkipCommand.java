package command;

import chatgame.ChatGameQueue;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

/**
 * Created by Tre on 6/20/2016.
 */
public class SkipCommand extends ChatSystemCommand {

    public SkipCommand () {
        super("cgskip");
    }

    @Override
    void run(CommandSender sender, Object... args) {

        ChatGameQueue.startRandomGame();

        ChatHelper.sendBlueMessage(sender,
                "Skipped the current chat game.");

    }
}

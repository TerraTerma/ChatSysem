package command;

import chatgame.ChatGameQueue;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

public class SkipCommand extends ChatSystemCommand {

    public SkipCommand () {
        super("cgskip");
    }

    @Override
    boolean run(CommandSender sender, Object... args) {

        ChatGameQueue.startRandomGame();
        ChatHelper.sendBlueMessage(sender,
                "Skipped the current chat game.");

        return true;
    }
}

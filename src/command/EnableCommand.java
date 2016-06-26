package command;

import chatgame.ChatGame;
import chatgame.ChatGameQueue;
import chatgame.ChatGameRegistry;
import org.bukkit.command.CommandSender;
import utilities.ChatHelper;

import java.util.Optional;

public class EnableCommand extends ChatSystemCommand {

    public EnableCommand () {
        super("cgenable");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
        if (args.length == 0) return false;
        String name = (String) args[0];
        Optional<ChatGame> game = ChatGameRegistry.getChatGame(name);
        if (!game.isPresent())
            ChatHelper.sendRedMessage(sender, "Couldn't find the game "
            + name + ".");
        else {
            ChatGame chatGame = game.get();
            boolean success = ChatGameQueue.addGame(chatGame);
            if (success) ChatHelper.sendBlueMessage(sender, "Enabled "
            + chatGame.getName() + ".");
        }
        return true;
    }
}

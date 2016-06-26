package command;

import chatgame.ChatGame;
import chatgame.ChatGameQueue;
import org.bukkit.command.CommandSender;
import utilities.ChatHelper;

import java.util.Optional;

public class DisableCommand extends ChatSystemCommand{

    public DisableCommand () {
        super("cgdisable");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
        if (args.length == 0) return false;
        String name = (String) args[0];

        Optional<ChatGame> chatGameOptional =
                ChatGameQueue.getChatGame(name);

        if (chatGameOptional.isPresent()) {
            ChatGame game = chatGameOptional.get();
            if (game.isRunning()) game.stop();
            ChatGameQueue.removeGame(game);
            ChatHelper.sendBlueMessage(sender, "Disabled " + game.getName() + ".");
        }
        else ChatHelper.sendRedMessage(sender, "Couldn't find the chat game " +
                name + ".");
        return true;
    }
}

package command;

import chatgame.ChatGameQueue;
import org.bukkit.command.CommandSender;

public class GameReloadCommand extends ChatSystemCommand {

    public GameReloadCommand () {
        super("cgreload");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
        ChatGameQueue.reloadGames();
        sender.sendMessage("Reloaded chat games.");
        return true;
    }
}

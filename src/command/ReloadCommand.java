package command;

import chatgame.ChatGameQueue;
import configuration.ConfigurationManager;
import configuration.ChatConfiguration;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends ChatSystemCommand {

    public ReloadCommand () {
        super("csreload");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {

        boolean reloadHangman = false, reloadReaction = false;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg.equals("hangman")) reloadHangman = true;
                if (arg.equals("reaction")) reloadReaction = true;
            }
        }

        if (reloadHangman) {
            ConfigurationManager.reloadHangmanConfiguration();
            sender.sendMessage("Reloaded Hangman configuration.");
        }
        if (reloadReaction) {
            ConfigurationManager.reloadReactionConfiguration();
            sender.sendMessage("Reloaded Reaction configuration.");
        }

        if (reloadHangman || reloadReaction)
            ChatGameQueue.reloadGames();

        ConfigurationManager.reloadChatConfiguration();
        sender.sendMessage("Reloaded ChatSystem configuration.");
        return true;
    }
}

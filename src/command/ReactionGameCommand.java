package command;

import configuration.ConfigurationRegistry;
import utilities.ListCommunicator;
import configuration.ReactionGameConfiguration;
import org.bukkit.command.CommandSender;

public class ReactionGameCommand extends ChatSystemCommand {

    public ReactionGameCommand () {
        super("cgreaction");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {

        if (args.length != 2) return true;

        String operation = (String) args[0];
        String word = (String) args[1];

        ReactionGameConfiguration gameConfiguration =
                (ReactionGameConfiguration) ConfigurationRegistry.getConfiguration("reaction.yml");

        ListCommunicator listCommunicator = new ListCommunicator(gameConfiguration, ReactionGameConfiguration.WORDS);

        if (operation.equals("add")) {
            listCommunicator.addWord(word);
            sender.sendMessage("Added the word " + word + " to reaction.");
        }

        else if (operation.equals("remove")) {
            listCommunicator.removeWord(word);
            sender.sendMessage("Removed the word " + word + " from reaction.");
        }

        return true;
    }

}

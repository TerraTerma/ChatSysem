package command;

import configuration.ConfigurationRegistry;
import utilities.ListCommunicator;
import configuration.SwearConfiguration;

import org.bukkit.command.CommandSender;

public class SwearsCommand extends ChatSystemCommand {

    public SwearsCommand () {
        super("csswears");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {

        if (args.length != 2){
        	sender.sendMessage("/csswears <add/remove> <swearword>");
        	return true;
        }
        String operation = (String) args[0];
        String word = (String) args[1];

        SwearConfiguration swearConfiguration =
                (SwearConfiguration) ConfigurationRegistry.getConfiguration("swear-list.yml");

        ListCommunicator listCommunicator = new ListCommunicator(swearConfiguration, SwearConfiguration.SWEAR_LIST);

        if (operation.equals("add")) {
            listCommunicator.addWord(word);
            sender.sendMessage("Added the word " + word + " to the swears list.");
        }

        else if (operation.equals("remove")) {
            listCommunicator.removeWord(word);
            sender.sendMessage("Removed the word " + word + " from the swears list.");
        }

        return true;
    }

}

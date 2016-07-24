package command;

import configuration.ChatConfiguration;
import configuration.MessageConfiguration;
import utilities.FormatTemplate;
import utilities.StaffChatFormatter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utilities.ChatHelper;

import java.util.Collection;

public class SCCommand extends ChatSystemCommand{

	private StaffChatFormatter staffChatFormatter = new StaffChatFormatter();

    public SCCommand () {
        super("sc");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
		Player player = (Player) sender;
		if (args.length == 0){
			String insertFormat = (String) MessageConfiguration.STAFF_CHAT_INSERT_FORMAT.getValue();
			player.sendMessage(ChatHelper.colorText(insertFormat));
		}
		if (args.length > 0) {
			StringBuilder builder = new StringBuilder();
            for (Object arg : args) {
                builder.append(" ");
                builder.append(arg);
            }
			String message = builder.toString();
			String format = (String) ChatConfiguration.STAFF_CHAT_FORMAT.getValue();
			FormatTemplate formatTemplate = new FormatTemplate(format);
			formatTemplate.setPlayer(player);
			formatTemplate.setMessage(message);

            Collection<? extends Player> players = Bukkit.getOnlinePlayers();
            for (Player p : players){
                if (!p.hasPermission("cs.staffchat")) continue;
                String formattedText = staffChatFormatter.formatStaffChat(formatTemplate);
                String coloredText = ChatHelper.colorText(formattedText);
                p.sendMessage(coloredText);
            }
        }
        return true;
    }
}

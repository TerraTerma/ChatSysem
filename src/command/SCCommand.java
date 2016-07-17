package command;

import configuration.ChatConfiguration;
import utilities.FormatTemplate;
import event.MentionFormatter;
import event.StaffChatFormatter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utilities.ChatHelper;

public class SCCommand extends ChatSystemCommand{

	private StaffChatFormatter staffChatFormatter = new StaffChatFormatter();
	private MentionFormatter mentionFormatter = new MentionFormatter();

    public SCCommand () {
        super("sc");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
		Player player = (Player) sender;
		if (args.length == 0){
			player.sendMessage(ChatHelper.colorText("&8[&6Staff-Chat&8] &2Please insert a staff-chat message."));
		}
		if (args.length > 0){
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				builder.append(" ");
				builder.append(args[i]);
			}
			String message = builder.toString();
			String format = (String) ChatConfiguration.STAFF_CHAT_FORMAT.getValue();
			FormatTemplate formatTemplate = new FormatTemplate(format);
			formatTemplate.setPlayer(player);
			formatTemplate.setMessage(message);
			for (Player all : Bukkit.getOnlinePlayers()){
				if (all.hasPermission("cs.staffchat")){
					String formattedText = staffChatFormatter.formatStaffChat(formatTemplate);
					String coloredText = ChatHelper.colorText(formattedText);
					all.sendMessage(coloredText);
				}
			}
		}
    	return true;
    }
}

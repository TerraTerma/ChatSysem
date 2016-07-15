package command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;
import utilities.ChatHelper;

public class StaffChatCommand extends ChatSystemCommand{
    public StaffChatCommand () {
        super("sc");
    }

    @Override
    boolean run (CommandSender sender, Object... args) {
    	Player player = (Player) sender;
    	if (args.length == 0){
    		player.sendMessage(ChatHelper.colorText("&8[&6Staff-Chat&8] &2Please insert a message."));
    	}
    	if (args.length > 0){
    	       StringBuilder builder = new StringBuilder();
      for (int i = 0; i < args.length; i++) {
    	       builder.append(" ");
    	       builder.append(args[i]);
    		  }
    	      String StaffChatMSG = builder.toString();
    		for (Player all : Bukkit.getOnlinePlayers()){
    			if (all.hasPermission("cs.staffchat")){
    				all.sendMessage(ChatHelper.colorText("&8[&6Staff-Chat&8] " + player.getName() + "&8 :&b" + StaffChatMSG));
    			}
    		}
    	}
    	return true;
    }
}

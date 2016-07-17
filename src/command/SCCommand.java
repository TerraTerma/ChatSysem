package command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import utilities.ChatHelper;

public class SCCommand extends ChatSystemCommand{
    public SCCommand () {
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

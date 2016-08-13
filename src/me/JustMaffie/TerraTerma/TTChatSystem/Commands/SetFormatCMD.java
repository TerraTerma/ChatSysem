package me.JustMaffie.TerraTerma.TTChatSystem.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import TTCore.Entity.Living.Human.Player.TTPlayer;
import me.JustMaffie.TerraTerma.TTChatSystem.Main;
import me.JustMaffie.TerraTerma.TTChatSystem.Mechs.MessageFormatData;
import me.JustMaffie.TerraTerma.TTChatSystem.Utilities.ChatHelper;

public class SetFormatCMD implements CommandExecutor{

	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args){
		TTPlayer p = TTPlayer.getPlayer((Player) s);
		if (args.length == 0){
			if (p.getRank().isStaff()){
			p.sendMessage(Main.getPlugin(), ChatHelper.colorText("&8[&2Chat-System&8]&2 Usage: /setformat [chat|staffchat] [format]"));
		}else{
			p.sendMessage(Main.getPlugin(), ChatHelper.colorText("&8[&2Chat-System&8]&2 Usage: /setformat [chat] [format]"));

		}}

        if (args[0].equalsIgnoreCase("staffchat") && args.length > 1){
    		StringBuilder sb = new StringBuilder();
    		for (int i = 2; i < args.length; i++) {
                sb.append(" ");
                sb.append(args[i]);
            }
        	if (p.getRank().isStaff()){
        		MessageFormatData.getThaClass().setStaffChatFormat(sb.toString());
        		p.sendMessage(new Main(), "You changed your StaffChat format to " + sb.toString());
        	}
        }else if(args[0].equalsIgnoreCase("chat") && args.length > 1){
    		StringBuilder sb = new StringBuilder();
    		for (int i = 2; i < args.length; i++) {
                sb.append(" ");
                sb.append(args[i]);
            }
    		MessageFormatData.getThaClass().setChatFormat(sb.toString());
    		p.sendMessage(Main.getPlugin(), ChatHelper.colorText("You changed your Chat format to " + sb.toString()));
        }else if(!args[0].equalsIgnoreCase("staffchat") && !args[0].equalsIgnoreCase("chat") && args.length == 1){
			if (p.getRank().isStaff()){
			p.sendMessage(Main.getPlugin(), ChatHelper.colorText("&8[&2Chat-System&8]&2 Usage: /setformat [chat|staffchat] [format]"));
		}else{
			p.sendMessage(Main.getPlugin(), ChatHelper.colorText("&8[&2Chat-System&8]&2 Usage: /setformat [chat] [format]"));

		}
        }
        
		return false;
	}
	
}

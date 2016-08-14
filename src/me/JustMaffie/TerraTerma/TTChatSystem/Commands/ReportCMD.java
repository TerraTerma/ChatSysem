package me.JustMaffie.TerraTerma.TTChatSystem.Commands;

import java.util.Optional;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import TTCore.Entity.Living.Human.Player.TTAccount;
import TTCore.Entity.Living.Human.Player.TTPlayer;
import me.JustMaffie.TerraTerma.TTChatSystem.Report;
import me.JustMaffie.TerraTerma.TTChatSystem.Mechs.ReportsData;

public class ReportCMD implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (sender instanceof Player){
			TTPlayer ttp = TTPlayer.getPlayer((Player) sender);

		if (args.length < 2){
			ttp.sendMessage("&8[&6&lChatSystem&8] &4Usage: /report [player] [reason]");
			return true;
		}
		if (args.length > 1){
		    String reason = null;
		    for (int A = 1; A < args.length; A++) {
		    	String message = args[A];
		     	if (reason == null) {
		      	reason = message;
		     	} else {
		      	reason = (reason + " " + message);
		     	}
		    }
		    Optional<TTAccount> opReporting = TTAccount.getAccount(args[0]);
		    if(opReporting.isPresent()){
		    	TTAccount reporting = opReporting.get();
          
		    	Report report = new Report(ttp, reason);
		   	 	ReportsData data = reporting.getSingleData(ReportsData.class).get();
		    	data.getList().add(report);
          
		    	reporting.saveAll();
		    	ttp.sendMessage("&8[&6&lChatSystem&8] &2You reported " + reporting.getPlayer().getName() + " for " + reason);
		    }
		    return true;
			}
		}
		
		return false;
	}
}

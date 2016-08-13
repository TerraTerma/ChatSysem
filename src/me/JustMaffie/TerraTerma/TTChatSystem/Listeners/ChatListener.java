package me.JustMaffie.TerraTerma.TTChatSystem.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import TTCore.Entity.Living.Human.Player.TTPlayer;

public class ChatListener implements Listener{

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		
		TTPlayer ttPlayer = TTPlayer.getPlayer(e.getPlayer());
		//Player bukkitPlayer = ttPlayer.getPlayer();
		TTPlayer.getPlayers().stream().forEach(player -> {
			((TTPlayer)player).sendMessageFromPlayer(ttPlayer, e.getMessage());
			});
		
		
	}
}

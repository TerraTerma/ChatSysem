package me.JustMaffie.TerraTerma.TTChatSystem.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import TTCore.Entity.Living.Human.Player.TTPlayer;
import me.JustMaffie.TerraTerma.TTChatSystem.Utilities.ChatHelper;

public class ChatListener implements Listener{

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		TTPlayer p = TTPlayer.getPlayer(e.getPlayer());
		e.setFormat(ChatHelper.colorText("&8[&6&l" + p.getPermissionGroup().getPrefix() + "&8] [&6&l" + p.getPlayer().getDisplayName() + "&8]&6 " + e.getMessage()));
	}
}

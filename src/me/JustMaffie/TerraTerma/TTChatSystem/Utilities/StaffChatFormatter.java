package me.JustMaffie.TerraTerma.TTChatSystem.Utilities;

import org.bukkit.entity.Player;

public class StaffChatFormatter {

    public String formatStaffChat (FormatTemplate formatTemplate) {
        Player player = formatTemplate.getPlayer();
        String playerName = player.getName();
        String message = formatTemplate.getMessage();
        String format = formatTemplate.getFormat();
        format = format.replaceAll("%player%", playerName);
        format = format.replaceAll("%message%", message);
        return format;
    }

}

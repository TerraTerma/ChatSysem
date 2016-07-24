package utilities;

import org.bukkit.entity.Player;
import utilities.FormatTemplate;

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

package utilities;

import org.bukkit.entity.Player;

public class FormatTemplate {

    private Player player;
    private String message;
    private String format;

    public FormatTemplate (String format) {
        this.format = format;
    }

    public Player getPlayer () {
        return player;
    }

    public void setPlayer (Player player) {
        this.player = player;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getFormat () {
        return format;
    }

    public void setFormat (String format) {
        this.format = format;
    }

}

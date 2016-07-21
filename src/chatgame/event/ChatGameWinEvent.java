package chatgame.event;

import org.bukkit.entity.Player;

import chatgame.ChatGame;

public class ChatGameWinEvent extends ChatGameEvent {

	private Player player;
    private String time;

	public ChatGameWinEvent (ChatGame chatGame) {
		super (chatGame);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
	    this.player = player;
    }

    public String getTime () {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }

}

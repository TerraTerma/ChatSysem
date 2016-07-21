package chatgame.event;

import chatgame.ChatGame;
import chatgame.game.ReactionGame;
import org.bukkit.entity.Player;
import utilities.ChatHelper;

public class ChatGameEvents implements ChatGameListener {

	@Override
	public void onEventFire(ChatGameEvent event) {

		ChatGameWinEvent winEvent;

		ChatGame chatGame = event.getChatGame();
		String name = chatGame.getName();

		if (event instanceof ChatGameWinEvent) {
			winEvent = (ChatGameWinEvent) event;

            if (chatGame instanceof ReactionGame) {
                Player winner = winEvent.getPlayer();
                String winnerName = winner.getName();
                ChatHelper.broadcastAquaMessage(winnerName + " guessed the word " +
                        "in " + winEvent.getTime() + " seconds.");
            }

			ChatHelper.broadcastPinkMessage(winEvent.getPlayer().getName()
			+ " has won " + name + ".");

		}

		if (event instanceof ChatGameEndEvent)
			ChatHelper.broadcastGoldMessage(name + " has ended.");

		event.getChatGame().stop();

	}

}

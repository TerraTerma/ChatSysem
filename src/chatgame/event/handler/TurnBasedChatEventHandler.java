package chatgame.event.handler;

import chatgame.ChatGame;
import chatgame.ChatGameChatListener;
import chatgame.ChatGameQueue;
import chatgame.event.TurnBasedChatEvent;
import chatgame.event.listener.ChatGameListener;
import chatgame.event.listener.TurnBasedChatListener;

import java.util.Optional;

public class TurnBasedChatEventHandler extends ChatGameHandler {

	public static void fireEvent (TurnBasedChatEvent event) {

		Optional<ChatGame> game = ChatGameQueue.getRunningGame();
		if (!game.isPresent()) return;
		ChatGame chatGame = game.get();
		if (chatGame instanceof TurnBasedChatListener)
			((TurnBasedChatListener) chatGame).onTurnBasedChat(event);

	}
	
}

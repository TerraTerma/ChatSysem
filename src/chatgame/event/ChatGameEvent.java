package chatgame.event;

import chatgame.ChatGame;

public class ChatGameEvent {

    private ChatGame chatGame;

    ChatGameEvent (ChatGame chatGame) {
        this.chatGame = chatGame;
    }

    public ChatGame getChatGame () {
        return chatGame;
    }

}

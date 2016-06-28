package chatgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import chatgame.event.ChatGameHandler;
import chatgame.event.ChatGameListener;
import configuration.ChatGameConfiguration;
import configuration.ConfigurationRegistry;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import main.Main;

public class ChatGameRegistry {

    private static Main main;
    private static List<ChatGame> chatGames;

    private static ChatGameChatListener chatGameChatListener;

    public ChatGameRegistry(Main main) {
        ChatGameRegistry.main = main;
        chatGames = new ArrayList<>();
        chatGameChatListener = new ChatGameChatListener();
    }

    public static List<ChatGame> getChatGames () {
        return  chatGames;
    }

    public static Optional<ChatGame> getChatGame (String name) {
        return chatGames.stream()
                        .filter(e -> e.getName().equalsIgnoreCase(name))
                        .findAny();
    }

    public static void fillQueue() {
        chatGames.forEach(ChatGameQueue::addGame);
    }

    public static void registerGame(ChatGame chatGame) {
        registerEvents(chatGame, main);
        registerCustomEvents(chatGame);

        chatGames.add(chatGame);
        chatGameChatListener.listenOn(chatGame);

        HandlerList.unregisterAll(chatGameChatListener);
        registerEvents(chatGameChatListener, main);

        ChatGameQueue.addGame(chatGame);
    }

    public static void registerGame (ChatGame chatGame, ChatGameConfiguration configuration) {
        registerGame(chatGame);
        ConfigurationRegistry.registerConfiguration(configuration);
    }

    private static void registerEvents(Listener listener, JavaPlugin javaPlugin) {
        main.getServer()
                .getPluginManager()
                .registerEvents(listener, javaPlugin);
    }

    private static void registerCustomEvents(ChatGame chatGame) {
        if (chatGame instanceof ChatGameListener)
            ChatGameHandler.addListener
                    ((ChatGameListener) chatGame);
    }

}

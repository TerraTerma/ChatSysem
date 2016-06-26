package configuration;

public class ConfigurationManager {

    private static ReactionGameConfiguration reactionGameConfiguration;
    private static HangmanGameConfiguration hangmanGameConfiguration;
    private static ChatConfiguration chatConfiguration;

    public ConfigurationManager () {
        reactionGameConfiguration = new ReactionGameConfiguration();
        hangmanGameConfiguration = new HangmanGameConfiguration();
        chatConfiguration = new ChatConfiguration();
    }

    public static void reloadHangmanConfiguration () {
        hangmanGameConfiguration.reload();
        System.out.println("Reloading the hangman game configuration.");
    }

    public static void reloadReactionConfiguration () {
        reactionGameConfiguration.reload();
        System.out.println("Reloading the reaction game configuration.");
    }

    public static void reloadChatConfiguration () {
        chatConfiguration.reload();
        System.out.println("Reloaded the chat configuration.");
    }

}

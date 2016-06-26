package configuration;

public class ConfigurationManager {

    private static ReactionGameConfiguration reactionGameConfiguration;
    private static HangmanGameConfiguration hangmanGameConfiguration;
    private static ChatConfiguration chatConfiguration;
    private static GroupConfiguration groupConfiguration;

    public ConfigurationManager () {
        reactionGameConfiguration = new ReactionGameConfiguration();
        hangmanGameConfiguration = new HangmanGameConfiguration();
        chatConfiguration = new ChatConfiguration();
        groupConfiguration = new GroupConfiguration();

        reloadConfigurations();
    }

    public static void reloadConfigurations () {
        reactionGameConfiguration.reload();
        hangmanGameConfiguration.reload();
        chatConfiguration.reload();
        groupConfiguration.reload();
    }

}

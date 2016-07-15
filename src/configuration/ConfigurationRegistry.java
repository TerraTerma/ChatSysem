package configuration;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationRegistry {

    private static List<ChatSystemConfiguration> configurationList;

    public ConfigurationRegistry () {
        configurationList = new ArrayList<>();
    }

    public static void registerConfiguration (ChatSystemConfiguration configuration) {
        configurationList.add(configuration);
        reloadConfigurations();
        System.out.println("Registered the configuration " +
                configuration.getClass().getName());
    }

    public static void reloadConfigurations () {
        configurationList.forEach(ChatSystemConfiguration::reload);
    }

    public static ChatSystemConfiguration getConfiguration (String fileName) {
        return configurationList.stream()
                         .filter(e -> e.getFile().getName().equals(fileName))
                         .findAny().get();
    }

}

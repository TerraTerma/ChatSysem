package configuration;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationRegistry {

    private static List<ChatSystemConfiguration> configurationList;

    public ConfigurationRegistry () {
        configurationList = new ArrayList<>();
        reloadConfigurations();
    }

    public static void registerConfiguration (ChatSystemConfiguration configuration) {
        configurationList.add(configuration);
        System.out.println("Registered the configuration " +
                configuration.getClass().getName());
    }

    public static void reloadConfigurations () {
        configurationList.forEach(ChatSystemConfiguration::reload);
    }

}

package configuration;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

abstract class ChatSystemConfiguration {

    private File file;
    private YamlConfiguration configuration;

    ChatSystemConfiguration (String path) {
        file = new File("plugins/TTChatSystem/" + path);
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    private void load () {
        try {
            configuration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    Object getSection (KeyValuePair keyValuePair) {
        String key = keyValuePair.getKey();
        return configuration.get(key);
    }

    void createSection (KeyValuePair keyValuePair) {
        String key = keyValuePair.getKey();
        Object value = keyValuePair.getValue();
        configuration.createSection(key);
        configuration.set(key, value);
    }

    void createSections (KeyValuePair[] keyValuePairs) {
        Arrays.stream(keyValuePairs).forEach(this::createSection);
    }

    void setSection (KeyValuePair keyValuePair) {
        String key = keyValuePair.getKey();
        Object value = keyValuePair.getValue();
        if (configuration.isSet(key)) return;
        configuration.set(key, value);
    }

    void setSections (KeyValuePair[] keyValuePairs) {
        Arrays.stream(keyValuePairs).forEach(this::setSection);
    }

    private void reload (KeyValuePair keyValuePair) {
        String key = keyValuePair.getKey();
        Object value = configuration.get(key);
        keyValuePair.setValue(value);
        System.out.println("The value of this key is "+ keyValuePair.getValue() + ".");
    }

    abstract void reload ();

    void reload (KeyValuePair[] keyValuePairs) {
        load();
        Arrays.stream(keyValuePairs)
                .forEach(this::reload);
        save();
    }

    void save () {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

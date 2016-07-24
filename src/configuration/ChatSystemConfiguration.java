package configuration;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import utilities.KeyValuePair;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class ChatSystemConfiguration {

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

    public void setSection (KeyValuePair keyValuePair, boolean overwrite) {
        String key = keyValuePair.getKey();
        Object value = keyValuePair.getValue();
        if (configuration.isSet(key) && !overwrite) return;
        configuration.set(key, value);
        save();
    }

    void setSections (KeyValuePair[] keyValuePairs) {
        Arrays.stream(keyValuePairs).forEach(e -> setSection(e, false));
    }

    void setSections (List<KeyValuePair> keyValuePairList, boolean overwrite) {
        keyValuePairList.forEach(e -> setSection(e, overwrite));
    }

    abstract void reload ();

    public void reload (KeyValuePair keyValuePair) {
        String key = keyValuePair.getKey();
        Object value = configuration.get(key);
        keyValuePair.setValue(value);
    }

    void reload (KeyValuePair[] keyValuePairs) {
        reload (Arrays.asList(keyValuePairs));
    }

    void reload (List<KeyValuePair> keyValuePairList) {
        load();
        keyValuePairList.forEach(this::reload);
        save();
    }

    private void save () {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile () {
        return file;
    }

}

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ChatConfig {

	private YamlConfiguration config;
	
	private File file;
	
	/**
	 * The ChatSystem plugin configuration class that handles
	 * configuration functions such as saving and loading values.
	 * @param path
	 */
	public ChatConfig(String path) {
		file = new File(path);
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		config = YamlConfiguration.loadConfiguration(file);

		for (ConfigSection configSection : ConfigSection.values()) {
			if(config.isSet(configSection.getPath()))
				configSection.setValue(config.get(configSection.getPath()));
			else set(configSection, configSection.getDefaultValue());
		}

	}

	public Object getObject(ConfigSection section) {
		return config.get(section.getPath());
	}
	
	public String getString (ConfigSection section) {
		return config.getString(section.getPath());
	}
	
	public void set (ConfigSection section, Object value) {
		config.set(section.getPath(), value);
		section.setValue(value);
	}

	public void set(ConfigSection section, String value) {
		config.set(section.getPath(), value);
		section.setValue(value);
	}
	
	public void save () {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Saved");
	}
	
}

enum ConfigSection {
	CHAT_FORMAT("chat.format", "(%world%) %player%: %message%"),
	WORLD_COLOR("chat.world-color", "&7"),
	PLAYER_COLOR("chat.player-color", "&e"),
	MESSAGE_COLOR("chat.message-color", "&d"),
	MENTION_PREFIX("mention.format", "&b&o@");

	private String path;
	private Object defaultValue;
	private Object value;
	
	/**
	 * The configuration sections and default values used in the chat configuration file.
	 * @param path
	 * @param defaultValue
	 */
	ConfigSection(String path, Object defaultValue) {
		this.path = path;
		this.defaultValue = defaultValue;
		this.value = defaultValue;
	}
	
	/**
	 * Get the configuration path of the specified section.
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Get the default value of the chat format.
	 * @return
	 */
	public Object getDefaultValue() {
		return defaultValue;
	}
	
	public Object getValue () {
		return value;
	}
	
	public void setValue (Object value) {
		this.value = value;
	}
}
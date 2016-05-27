import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import com.pciot.terraterma.API.Utils.Saver.Saver;

public class ChatConfig extends Saver {

	private YamlConfiguration config;
	
	/**
	 * The ChatSystem plugin configuration class that handles
	 * configuration functions such as saving and loading values.
	 * @param path
	 */
	public ChatConfig(String path) {
		super(new File(path));
		
		config = getConfig();
		
		for (ConfigSection configSection : ConfigSection.values()) {
			if (!config.isConfigurationSection(configSection.getPath())) {
				set(configSection.getDefaultValue(), configSection.getPath());
			}
		}
		
		save();
	}

	/**
	 * Get the format of chat messages from the configuration file.
	 * @return String representation of the chat format.
	 */
	public String getFormat() {
		return config.getString(ConfigSection.CHAT_FORMAT.getPath());
	}

	/**
	 * Set the format of chat messages in the configuration file.
	 * @param format String representation of the chat format.
	 */
	public void setFormat(String format) {
		config.set(ConfigSection.CHAT_FORMAT.getPath(), format);
	}
	
	/**
	 * Get the mention prefix appended to the players name
	 * when mentioned in chat.
	 * @return Prefix string.
	 */
	public String getMentionPrefix () {
		return config.getString(ConfigSection.MENTION_PREFIX.getPath());
	}
	
	/**
	 * Set the mention prefix appended to the playes name
	 * when mentioned in chat.
	 * @param prefix The prefix to use.
	 */
	public void setMentionPrefix (String prefix) {
		config.set(ConfigSection.MENTION_PREFIX.getPath(), prefix);
	}

}

enum ConfigSection {
	CHAT_FORMAT("chat.format", "&7(%world%) &e%player%&f:& d%message%"),
	MENTION_PREFIX("mention.format", "@");

	private String path;
	private Object defaultValue;

	/**
	 * The configuration sections and default values used in the chat configuration file.
	 * @param path
	 * @param defaultValue
	 */
	ConfigSection(String path, Object defaultValue) {
		this.path = path;
		this.defaultValue = defaultValue;
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
}

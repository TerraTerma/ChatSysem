import java.io.File;

import com.pciot.terraterma.API.Utils.Saver.Saver;

public class ChatConfig extends Saver {

	/**
	 * The ChatSystem plugin configuration class that handles
	 * configuration functions such as saving and loading values.
	 * @param path
	 */
	public ChatConfig(String path) {
		super(new File(path));
		
		if (!getConfig().isConfigurationSection(ConfigSections.CHAT_FORMAT.getPath())) {
			set(ConfigSections.CHAT_FORMAT.getDefaultValue(), ConfigSections.CHAT_FORMAT.getPath());
		}
		
		save();
	}

	/**
	 * Get the format of chat messages from the configuration file.
	 * @return String representation of the chat format.
	 */
	public String getFormat() {
		return get(String.class, ConfigSections.CHAT_FORMAT.getPath());
	}

	/**
	 * Set the format of chat messages in the configuration file.
	 * @param format String representation of the chat format.
	 */
	public void setFormat(String format) {
		set(format, ConfigSections.CHAT_FORMAT.getPath());
	}

}

enum ConfigSections {
	CHAT_FORMAT("chat.format", "%world% %player%");

	private String path;
	private Object defaultValue;

	private ConfigSections(String path, Object defaultValue) {
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

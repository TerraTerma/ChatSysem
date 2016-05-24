import java.io.File;

import com.pciot.terraterma.API.Utils.Saver.Saver;

public class ChatConfig extends Saver {

	public ChatConfig(String path) {
		super(new File(path));
		if (!getConfig().isConfigurationSection(ConfigSections.CHAT_FORMAT.getPath())) {
			set(ConfigSections.CHAT_FORMAT.getDefaultValue(), ConfigSections.CHAT_FORMAT.getPath());
		}
		save();
	}

	public String getFormat() {
		return get(String.class, ConfigSections.CHAT_FORMAT.getPath());
	}

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

	public String getPath() {
		return path;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

}

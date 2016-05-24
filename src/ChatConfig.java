import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ChatConfig {

	private File file;
	private YamlConfiguration yamlConfiguration;
	
	public ChatConfig (String path) {
		
		file = new File(path);
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		if (!yamlConfiguration.isConfigurationSection(ConfigSections.CHAT_FORMAT.getPath())) {
			yamlConfiguration.set(ConfigSections.CHAT_FORMAT.getPath(), ConfigSections.CHAT_FORMAT.getDefaultValue());
		}
		
		saveConfiguration();
	}
	
	public String getFormat () {
		return yamlConfiguration.getString(ConfigSections.CHAT_FORMAT.getPath());
	}
	
	public void setFormat (String format) {
		yamlConfiguration.set(ConfigSections.CHAT_FORMAT.getPath(), format);
	}
	
	public File getFile () {
		return file;
	}
	
	public YamlConfiguration getYamlConfiguration () {
		return yamlConfiguration;
	}
	
	public void saveConfiguration () {
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

enum ConfigSections {
	CHAT_FORMAT ("chat.format", "%world% %player%");
	
	private String path;
	private Object defaultValue;
	
	private ConfigSections (String path, Object defaultValue) {
		this.path = path;
		this.defaultValue = defaultValue;
	}
	
	public String getPath() {
		return path;
	}
	
	public Object getDefaultValue () {
		return defaultValue;
	}
			
}

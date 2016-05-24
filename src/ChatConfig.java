import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
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
		
		yamlConfiguration = new YamlConfiguration();
		
		try {
			yamlConfiguration.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
	}
	
	public File getFile () {
		return file;
	}
	
	public YamlConfiguration getYamlConfiguration() {
		return yamlConfiguration;
	}
	
}

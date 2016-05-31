package chatgame.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ChatGameConfiguration {

	private String directory = "plugins/TTChatSystem/games/";
	
	private File file;
	
	private YamlConfiguration yamlConfiguration;
	
	public ChatGameConfiguration (String fileName) {
		
		file = new File(directory + fileName);
		
		yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
	}
	
	public File getFile () {
		return file;
	}
	
	public YamlConfiguration getYamlConfiguration () {
		return yamlConfiguration;
	}
	
	public void createSection(String path, Object value) {
		if (yamlConfiguration.isSet(path)) return;
		yamlConfiguration.set(path, value);
	}
	
	public void save () {
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

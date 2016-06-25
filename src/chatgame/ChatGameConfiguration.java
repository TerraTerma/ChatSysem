package chatgame;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class ChatGameConfiguration {

	private File file;
	
	private YamlConfiguration yamlConfiguration;
	
	public ChatGameConfiguration (String fileName) {
		
		file = new File("plugins/TTChatSystem/games/" + fileName);
		
		yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
	}
	
	protected YamlConfiguration getYamlConfiguration () {
		return yamlConfiguration;
	}
	
	protected void createSection(String path, Object value) {
		if (yamlConfiguration.isSet(path)) return;
		yamlConfiguration.set(path, value);
	}

	protected void load () {
		try {
			yamlConfiguration.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	protected void save () {
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

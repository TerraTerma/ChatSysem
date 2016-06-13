package main;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ChatConfig {

	private static YamlConfiguration config;
	
	private static File file;
	
	/**
	 * The ChatSystem plugin configuration class that handles
	 * configuration functions such as saving and loading values.
	 * @param path
	 */
	public ChatConfig (String path) {
		file = new File(path);

		config = YamlConfiguration.loadConfiguration(file);

		for (ConfigSection configSection : ConfigSection.values()) {
			if(config.isSet(configSection.getPath()))
				configSection.setValue(config.get(configSection.getPath()));
			else set(configSection, configSection.getDefaultValue());
		}

		save();
	}
	
	
	private static void set (ConfigSection section, Object value) {
		config.set(section.getPath(), value);
		section.setValue(value);
	}

	private static void save () {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Saved");
	}
	
}
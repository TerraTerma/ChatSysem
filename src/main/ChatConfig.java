package main;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class ChatConfig {

	private static YamlConfiguration config;
	
	private static File file;
	
	/**
	 * The ChatSystem plugin configuration class that handles
	 * configuration functions such as saving and loading values.
	 * @param path
	 */
	ChatConfig (String path) {
		file = new File(path);

		config = YamlConfiguration.loadConfiguration(file);

		reload();
		save();
	}
	
	public static void reload () {
		load();
		for (ConfigSection configSection : ConfigSection.values()) {
			if(config.isSet(configSection.getPath())) configSection.setValue(config.get(configSection.getPath()));
			else set(configSection, configSection.getDefaultValue());
		}

	}

	private static void set (ConfigSection section, Object value) {
		config.set(section.getPath(), value);
		section.setValue(value);
	}

	private static void load () {
		try {
			config.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
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
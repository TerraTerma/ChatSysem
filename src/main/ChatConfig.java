package main;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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

		for (ConfigSection configSection : ConfigSection.values()) {
			if(config.isSet(configSection.getPath())) {
				configSection.setValue(config.get(configSection.getPath()));
				System.out.println("Setting the config value.");
			}
			else {
				set(configSection, configSection.getDefaultValue());
				System.out.println("Creating the config value.");
			}
		}

		Arrays.stream(ConfigSection.values()).forEach(e -> System.out.println(e.getPath() + " " + e.getValue()));
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
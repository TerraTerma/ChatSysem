package configuration;

import java.util.ArrayList;
import java.util.List;

public class HangmanGameConfiguration extends ChatGameConfiguration {
	
	public static KeyValuePair PHRASES = new KeyValuePair();

	public HangmanGameConfiguration() {
		super("hangman.yml");

		List<String> phrases = new ArrayList<>();
		phrases.add("Best Developer");
		phrases.add("Evan Mosely");
		phrases.add("Luke Dooly");

		PHRASES.setKey("phrases");
		PHRASES.setValue(phrases);

		setSection(PHRASES);
		
		reload();
	}

	void reload () {
		super.reload(new KeyValuePair[] {PHRASES});
	}

}

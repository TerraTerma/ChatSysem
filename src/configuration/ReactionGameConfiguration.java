package configuration;

import utilities.KeyValuePair;

import java.util.ArrayList;
import java.util.List;

public class ReactionGameConfiguration extends ChatGameConfiguration {

	public static final KeyValuePair WORDS = new KeyValuePair();

	public ReactionGameConfiguration() {
		super("reaction.yml");
		
		List<String> words = new ArrayList<>();
		words.add("Bacon");
		words.add("Reaction");
		words.add("Cool!");

		WORDS.setKey("words");
		WORDS.setValue(words);

		setSection(WORDS, false);
	}

	void reload () {
		super.reload(new KeyValuePair[] {WORDS});
	}

}

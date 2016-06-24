package chatgame.reaction;

import chatgame.ChatGameConfiguration;

import java.util.ArrayList;
import java.util.List;

class ReactionGameConfiguration extends ChatGameConfiguration {

	private List<String> words;
	
	ReactionGameConfiguration() {
		super("reaction.yml");
		
		words = new ArrayList<>();
		words.add("Bacon");
		words.add("Reaction");
		words.add("Cool!");
		
		createSection("words", words);

		save();
	}

	List<String> getWords () {
		return super.getYamlConfiguration().getStringList("words");
	}
	
}

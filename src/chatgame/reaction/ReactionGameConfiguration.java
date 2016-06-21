package chatgame.reaction;

import java.util.ArrayList;
import java.util.List;

import chatgame.ChatGameConfiguration;

public class ReactionGameConfiguration extends ChatGameConfiguration {

	private List<String> words;
	
	public ReactionGameConfiguration() {
		super("reaction.yml");
		
		words = new ArrayList<>();
		words.add("Bacon");
		words.add("Reaction");
		words.add("Cool!");
		
		createSection("words", words);

		save();
	}

	public List<String> getWords () {
		return super.getYamlConfiguration().getStringList("words");
	}
	
}
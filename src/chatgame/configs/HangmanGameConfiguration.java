package chatgame.configs;

import java.util.ArrayList;
import java.util.List;

public class HangmanGameConfiguration extends ChatGameConfiguration {
	
	List<String> phrases;
	
	public HangmanGameConfiguration() {
		super("hangman.yml");
		
		phrases = new ArrayList<>();
		phrases.add("Best Developer");
		phrases.add("Evan Mosely");
		phrases.add("Luke Dooly");
		
		createSection("phrases", phrases);
		
		phrases = getYamlConfiguration()
				.getStringList("phrases");
	}
	
	public List<String> getPhrases () {
		return phrases;
	}
	
}

package chatgame.hangman;

import java.util.ArrayList;
import java.util.List;

import chatgame.ChatGameConfiguration;

class HangmanGameConfiguration extends ChatGameConfiguration {
	
	List<String> phrases;
	
	HangmanGameConfiguration() {
		super("hangman.yml");
		
		phrases = new ArrayList<>();
		phrases.add("Best Developer");
		phrases.add("Evan Mosely");
		phrases.add("Luke Dooly");
		
		createSection("phrases", phrases);
		
		phrases = getYamlConfiguration()
				.getStringList("phrases");
	}
	
	List<String> getPhrases () {
		return phrases;
	}
	
}

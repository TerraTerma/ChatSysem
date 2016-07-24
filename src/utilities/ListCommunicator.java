package utilities;

import configuration.ChatSystemConfiguration;

import java.util.List;

public class ListCommunicator {

    private ChatSystemConfiguration configuration;
    private KeyValuePair keyValuePair;

    public ListCommunicator (ChatSystemConfiguration configuration, KeyValuePair keyValuePair) {
        this.configuration = configuration;
        this.keyValuePair = keyValuePair;
    }

    public void addWord (String word) {
        modifyWords(true, word);
        System.out.println("Added the word " + word + " to reaction.");
    }

    public void removeWord (String word) {
        modifyWords(false, word);
        System.out.println("Removed the word " + word + " to reaction.");
    }

    private void modifyWords(boolean add, String word) {
        List<String> words = (List<String>) keyValuePair.getValue();
        if (add) words.add(word);
        else words.remove(word);
        keyValuePair.setValue(words);
        configuration.setSection(keyValuePair, true);
    }

}

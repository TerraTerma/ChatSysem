package configuration;

public abstract class ChatGameConfiguration extends ChatSystemConfiguration {

	public ChatGameConfiguration(String fileName) {
		super("games/" + fileName);
	}

}

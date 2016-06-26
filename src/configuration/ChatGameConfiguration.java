package configuration;

abstract class ChatGameConfiguration extends ChatSystemConfiguration {

	ChatGameConfiguration(String fileName) {
		super("games/" + fileName);
	}

}

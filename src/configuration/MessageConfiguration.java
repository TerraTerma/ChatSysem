package configuration;

public class MessageConfiguration extends ChatSystemConfiguration {


	public static final KeyValuePair STAFF_CHAT_INSERT_FORMAT = new KeyValuePair();

	private KeyValuePair[] keyValuePairs =  {
			STAFF_CHAT_INSERT_FORMAT
	};

	public MessageConfiguration () {
		super("messages.yml");

        STAFF_CHAT_INSERT_FORMAT.set("staff-chat.insertmessage", "&8[&6Staff-Chat&8] &2Please insert a message.");

		setSections(keyValuePairs);
	}

	@Override
	void reload () {
		super.reload(keyValuePairs);
	}
}
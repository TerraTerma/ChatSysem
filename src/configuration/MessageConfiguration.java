package configuration;

public class MessageConfiguration extends ChatSystemConfiguration {


	public static final KeyValuePair STAFF_CHAT_INSERT_FORMAT = new KeyValuePair();
	public static final KeyValuePair WEBSITE_FORMAT = new KeyValuePair();
	
	private KeyValuePair[] keyValuePairs =  {
			STAFF_CHAT_INSERT_FORMAT,
			WEBSITE_FORMAT
	};

	public MessageConfiguration () {
		super("messages.yml");

        STAFF_CHAT_INSERT_FORMAT.set("staff-chat.insertmessage", "&8[&6Staff-Chat&8] &2Please insert a message.");
        WEBSITE_FORMAT.set("website.format", "&8[&6&lSite&8] &6http://terraterma.byethost10.com/index");

		setSections(keyValuePairs);
	}

	@Override
	void reload () {
		super.reload(keyValuePairs);
	}
}
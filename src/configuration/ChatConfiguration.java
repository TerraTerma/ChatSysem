package configuration;

public class ChatConfiguration extends ChatSystemConfiguration {

	public static final KeyValuePair MENTION_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_AFK_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_SOUND = new KeyValuePair();
	public static final KeyValuePair MENTION_SOUND_VOLUME = new KeyValuePair();
	public static final KeyValuePair STAFF_CHAT_FORMAT = new KeyValuePair();
	public static final KeyValuePair TIMESTAMP = new KeyValuePair();
	public static final KeyValuePair STAFF_CHAT_INSERT_FORMAT = new KeyValuePair();

	private KeyValuePair[] keyValuePairs =  {
			MENTION_FORMAT,
			MENTION_AFK_FORMAT,
			MENTION_SOUND,
			MENTION_SOUND_VOLUME,
            TIMESTAMP,
			STAFF_CHAT_FORMAT,
			STAFF_CHAT_INSERT_FORMAT
	};

	public ChatConfiguration () {
		super("config.yml");

		MENTION_FORMAT.set("mention.format", "&b&o@");
		MENTION_AFK_FORMAT.set("mention.afk-format", "&3&o@");
		MENTION_SOUND.set("mention.sound", "ENTITY_COW_HURT");
		MENTION_SOUND_VOLUME.set("mention.volume", "0.75");
		STAFF_CHAT_FORMAT.set("staff-chat.format", "&c&l[Staff] %player% : &f&l%message%");
        STAFF_CHAT_INSERT_FORMAT.set("staff-chat.insertmessage", "&8[&6Staff-Chat&8] &2Please insert a message.");

        TIMESTAMP.set("timestamp", true);

		setSections(keyValuePairs);
	}

	@Override
	void reload () {
		super.reload(keyValuePairs);
	}
}
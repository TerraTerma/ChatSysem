package configuration;

public class ChatConfiguration extends ChatSystemConfiguration {

	public static final KeyValuePair MENTION_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_AFK_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_SOUND = new KeyValuePair();

	private KeyValuePair[] keyValuePairs =  {
			MENTION_FORMAT,
			MENTION_AFK_FORMAT,
			MENTION_SOUND
	};

	ChatConfiguration () {
		super("config.yml");

		MENTION_FORMAT.set("mention.format", "&b&o@");
		MENTION_AFK_FORMAT.set("mention.afk-format", "&3&o@");
		MENTION_SOUND.set("mention.sound", "ENTITY_COW_HURT");

		setSections(keyValuePairs);
	}

	@Override
	void reload () {
		super.reload(keyValuePairs);
	}
}
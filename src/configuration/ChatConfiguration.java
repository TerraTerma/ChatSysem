package configuration;

public class ChatConfiguration extends ChatSystemConfiguration {

	public static final KeyValuePair CHAT_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_AFK_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_SOUND = new KeyValuePair();

	private KeyValuePair[] keyValuePairs =  {
			CHAT_FORMAT,
			MENTION_FORMAT,
			MENTION_AFK_FORMAT,
			MENTION_SOUND
	};

	ChatConfiguration () {
		super("config.yml");

		CHAT_FORMAT.set("chat.format", "&8(%world%&8) %prefix% %player%&8: %message%");
		MENTION_FORMAT.set("mention.format", "&b&o@");
		MENTION_AFK_FORMAT.set("mention.afk-format", "&3&o@");
		MENTION_SOUND.set("mention.sound", "ENTITY_COW_HURT");

		setSections(keyValuePairs);

		setSection(CHAT_FORMAT);

		reload();
	}

	@Override
	void reload () {
		super.reload(keyValuePairs);
	}
}
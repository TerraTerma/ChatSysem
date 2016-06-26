package configuration;

public class ChatConfiguration extends ChatSystemConfiguration {

	public static final KeyValuePair CHAT_FORMAT = new KeyValuePair();
	public static final KeyValuePair WORLD_COLOR = new KeyValuePair();
	public static final KeyValuePair PLAYER_COLOR = new KeyValuePair();
	public static final KeyValuePair MESSAGE_COLOR = new KeyValuePair();
	public static final KeyValuePair MENTION_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_AFK_FORMAT = new KeyValuePair();
	public static final KeyValuePair MENTION_SOUND = new KeyValuePair();

	private KeyValuePair[] keyValuePairs =  {
			CHAT_FORMAT,
			WORLD_COLOR,
			PLAYER_COLOR,
			MESSAGE_COLOR,
			MENTION_FORMAT,
			MENTION_AFK_FORMAT,
			MENTION_SOUND
	};

	ChatConfiguration () {
		super("config.yml");

		CHAT_FORMAT.set("chat.format", "&8(%world%&8) %prefix% %player%&8: %message%");
		WORLD_COLOR.set("chat.world-color", "&7");
		PLAYER_COLOR.set("chat.player-color", "&7");
		MESSAGE_COLOR.set("chat.message-color", "&d");
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
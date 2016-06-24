package main;

public enum ConfigSection {
	CHAT_FORMAT("chat.format", "&8(%world%&8) %prefix% %player%&8: %message%"),
	WORLD_COLOR("chat.world-color", "&7"),
	PLAYER_COLOR("chat.player-color", "&7"),
	MESSAGE_COLOR("chat.message-color", "&d"),
	MENTION_FORMAT("mention.format", "&b&o@"),
	MENTION_AFK_FORMAT("mention.afk-prefix", "&3&o@"),
	MENTION_SOUND("mention.sound", "ENTITY_COW_HURT");

	private String path;
	private Object defaultValue;
	private Object value;
	
	/**
	 * The configuration sections and default values used in the chat configuration file.
	 * @param path
	 * @param defaultValue
	 */
	ConfigSection(String path, Object defaultValue) {
		this.path = path;
		this.defaultValue = defaultValue;
		this.value = defaultValue;
	}
	
	/**
	 * Get the configuration path of the specified section.
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Get the default value of the chat format.
	 * @return
	 */
	public Object getDefaultValue() {
		return defaultValue;
	}
	
	public String getValue () {
		return (String) value;
	}
	
	public void setValue (Object value) {
		this.value = value;
	}
}
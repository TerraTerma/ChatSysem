package configuration;

import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class GroupConfiguration extends ChatSystemConfiguration {

    private static List<KeyValuePair> groups = new ArrayList<>();

    public GroupConfiguration () {
        super("group-formats.yml");

        final String defaultFormat = "(%world%) [%prefix%] %player% : %message%";

        Collection<String> groupNames =
                PermissionsEx.getPermissionManager()
                             .getGroupNames();

        for (String groupName : groupNames) {
            KeyValuePair keyValuePair = new KeyValuePair(groupName);
            keyValuePair.setValue(defaultFormat);
            groups.add(keyValuePair);
        }

        setSections(groups);
    }

    public static String getGroupFormat (String groupName) {
        Optional<KeyValuePair> keyValuePairOptional =
                groups.stream()
                      .filter(e -> e.getKey().equals(groupName))
                      .findAny();

        if (keyValuePairOptional.isPresent()) {
            KeyValuePair keyValuePair = keyValuePairOptional.get();
            return keyValuePair.getValue().toString();
        }

        return null;
    }

    @Override
    void reload () {
        super.reload(groups);
    }
}

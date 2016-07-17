package configuration;

import java.util.ArrayList;
import java.util.List;

public class SwearConfiguration extends ChatSystemConfiguration {

    // This is the configuration section object
    public static final KeyValuePair SWEAR_LIST = new KeyValuePair();

    public  SwearConfiguration () {
        super("swear-list.yml");

        // the list of swears
        List<String> swears = new ArrayList<>();
        swears.add("FirstOneNotWorking");
        swears.add("fuck");
        swears.add("shit");
        swears.add("damn");

        // this sets the path and the value of the object
        SWEAR_LIST.set("swears", swears);

        // sets and saves the swearlist object to the config
        setSection(SWEAR_LIST, false);
    }

    @Override
    void reload () {
        // sets the value of the swearlist object to the object in the config
        super.reload(SWEAR_LIST);
    }


}

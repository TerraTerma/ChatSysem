package configuration;

import utilities.KeyValuePair;

import java.util.ArrayList;
import java.util.List;

public class SwearConfiguration extends ChatSystemConfiguration {

    public static final KeyValuePair SWEAR_LIST = new KeyValuePair();

    public  SwearConfiguration () {
        super("swear-list.yml");

        // the list of swears
        List<String> swears = new ArrayList<>();
        swears.add("fuck");
        swears.add("shit");
        swears.add("damn");

        SWEAR_LIST.set("swears", swears);

        setSection(SWEAR_LIST, false);
    }

    @Override
    void reload () {
        super.reload(SWEAR_LIST);
    }


}

package configuration;

import java.util.List;

public class KeyValuePair {

    private String key;
    private Object value;

    KeyValuePair () {}

    KeyValuePair (String key, Object value) {
        this.key = key;
        this.value = value;
    }

    KeyValuePair (String key) {
        this.key = key;
    }

    public String getKey () {
        return key;
    }

    public Object getValue () {
        return value;
    }

    public void setKey (String key) {
        this.key = key;
    }

    public void setValue (Object value) {
        this.value = value;
    }

    public void set (String key, Object value) {
        this.key = key;
        this.value = value;
    }

}

package me.JustMaffie.TerraTerma.TTChatSystem.Utilities;

public class KeyValuePair {

    private String key;
    private Object value;

    public KeyValuePair () {}

    public KeyValuePair (String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public KeyValuePair (String key) {
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

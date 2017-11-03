package session;

/**
 * Created by Iryna_Bartnytska on 11/3/2017.
 */
public enum Keys {

    EARTH_RESPONSE("EARTH_RESPONSE"),
    MARS_RESPONSE("MARS_RESPONSE");

    private final String key;

    Keys(final String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}

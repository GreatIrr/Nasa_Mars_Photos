package session;

import java.util.List;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SessionMap;

import jsons.models.Photos;

/**
 * Created by Iryna_Bartnytska on 11/3/2017.
 */
public class Session {

    private Session() {
    }

    public static Object get(final Keys keys) {
        String strKey = keys.toString();
        SessionMap<Object, Object> sessionMap = Serenity.getCurrentSession();
        Object value = sessionMap.get(strKey);

        if (value == null) {
            System.out.println("cannot find key = " + strKey);
        }

        return value;
    }

    public static <T extends Object> T getValue(final Keys keys, Class<T> tClass) {
        Object value = get(keys);
        return (value == null) ? null : (T) value;
    }

    public static String getStringValue(final Keys keys) {
        Object value = get(keys);
        return (value == null) ? null : value.toString();
    }

    public static void put(final Keys keys, final Object value) {
        Serenity.getCurrentSession().put(keys, value);
    }

    public static List<Photos> getEarthPhotoList() {
        return Session.getValue(Keys.EARTH_RESPONSE, List.class);
    }

    public static List<Photos> getMarsPhotoList() {
        return Session.getValue(Keys.MARS_RESPONSE, List.class);
    }

    public static void addMarsPhoto(final Photos photos) {
        if (!Session.containKeys(Keys.MARS_RESPONSE)) {
            Session.put(Keys.MARS_RESPONSE, photos);
        }
        Session.getValue(Keys.MARS_RESPONSE, List.class).add(photos);
    }

    public static void addEarthPhoto(final Photos photos) {
        if (!Session.containKeys(Keys.EARTH_RESPONSE)) {
            Session.put(Keys.EARTH_RESPONSE, photos);
        }
        Session.getValue(Keys.EARTH_RESPONSE, List.class).add(photos);
    }

    public static boolean containKeys(final Keys keys) {
        return Serenity.getCurrentSession().containsKey(keys);
    }

}

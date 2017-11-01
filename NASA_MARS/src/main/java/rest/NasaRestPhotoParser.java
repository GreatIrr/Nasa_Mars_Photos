package rest;

import commons.JsonParser;
import jsons.models.Mars;

import java.util.List;

/**
 * Created by Iryna_Bartnytska on 10/17/2017.
 */
public class NasaRestPhotoParser extends JsonParser {
    public static Mars parseNasaPhotoJson(final String body) {
        return fromJson(body, Mars.class);
    }

    public static String parseToString(final Object json) {
        return toJson(json);
    }

    public static String createJsonFromList(final List<String> list) {
        return toJson(list);
    }
}

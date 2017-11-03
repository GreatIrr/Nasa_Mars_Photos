package rest;

import commons.JsonParser;
import jsons.models.Mars;
import jsons.models.Photos;

import java.util.ArrayList;
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

    public static String createJsonFromPhotoList(final List<Photos> list) {
        List<String> result = new ArrayList<>();
        for(Photos o : list) {
            result.add(parseToString(o));
        }
        return createJsonFromList(result);
    }
}

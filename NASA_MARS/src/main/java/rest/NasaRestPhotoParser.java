package rest;

import commons.JsonParser;
import jsons.models.Mars;

/**
 * Created by Iryna_Bartnytska on 10/17/2017.
 */
public class NasaRestPhotoParser extends JsonParser {
    public static Mars parseNasaPhotoJson(final String body) {
        return fromJson(body, Mars.class);
    }
}

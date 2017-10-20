package commons;

import com.google.gson.Gson;

/**
 * Created by Iryna_Bartnytska on 10/17/2017.
 */
public abstract class JsonParser {

    public static <T extends Object> T fromJson(final String json, final Class<T> classTo) {
        return new Gson().fromJson(json, classTo);
    }

}

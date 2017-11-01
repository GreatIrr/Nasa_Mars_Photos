package commons;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Iryna_Bartnytska on 10/17/2017.
 */
public abstract class JsonParser {

    public static <T extends Object> T fromJson(final String json, final Class<T> classTo) {
        return new Gson().fromJson(json, classTo);
    }

    public static String toJson(final Object src) {
        return new Gson().toJson(src);
    }

    public static String toJson(final List<String> list) {
        return new Gson().toJson(list);
    }

}

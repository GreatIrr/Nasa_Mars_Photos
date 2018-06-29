package rest;

import org.junit.Test;

import annotations.Query;

/**
 * Created by Iryna_Bartnytska on 12/20/2017.
 */
public class MarsRest extends CommonRest {

    @Test
    public void getTestApod() {
        String host = getHost();
        System.out.println("the get host = " + host);
        String key = getApiKey();
        getTest(key);
        //return sendAndGetResponce(url);
    }

    public void getTest(@Query("api_key") String key) {
        try {
            testAnnotation(this.getClass().getMethod("getTest", String[].class), key);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

package rest;

import httpthings.AbstractRequest;
import httpthings.ResponseWrapper;
import org.apache.commons.lang.time.DateUtils;
import untils.ProjectProperties;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class NasaRest {

    private static ProjectProperties projectProperties = ProjectProperties.getInstance();
    private static final String HOST = projectProperties.getProperty("rest.nasa");
    private static final String REST_API_KEY = projectProperties.getProperty("rest.api.key");
    private static final String API_KEY = projectProperties.getProperty("api.key");
    private static final String MARS_PHOTOS = projectProperties.getProperty("mars.photos");
    private static final String MARS_1000_sol = projectProperties.getProperty("mars.1000.sol");
    private static final String LANDING_DATE = projectProperties.getProperty("mars.landing.date");
    private static final String EARTH_DATE = projectProperties.getProperty("earth.date");

    public ResponseWrapper getTestApod() {
        System.out.println("the get request " + HOST + REST_API_KEY + API_KEY);
        return AbstractRequest.get(HOST + REST_API_KEY + API_KEY).sendAndGetResponse();
    }

    public ResponseWrapper getMars1000Sol() {
        System.out.println("request = " + MARS_PHOTOS + MARS_1000_sol + REST_API_KEY + API_KEY);
        return AbstractRequest
                .get(MARS_PHOTOS + MARS_1000_sol + REST_API_KEY + API_KEY)
                .sendAndGetResponse();
    }

    public ResponseWrapper sendCustomRequest(final String url) {
        System.out.println("Custom url = " + url);
        return AbstractRequest.get(url).sendAndGetResponse();
    }

    public ResponseWrapper getMarsEarth1000Sol() {

        String earthDate1000Sol = getEarthDateNSol(1000) + "&";
        System.out.println("request = " + MARS_PHOTOS + EARTH_DATE + earthDate1000Sol + REST_API_KEY + API_KEY);
        return AbstractRequest.get(MARS_PHOTOS + EARTH_DATE + earthDate1000Sol + REST_API_KEY + API_KEY)
                .sendAndGetResponse();
    }

    private String getEarthDateNSol(final int sols) {
        double sol = 24 * 60 * 60 + 39 * 60 + 35.244147;  //hardcoded sol duration
        int sol1000 = (int) (sol * sols);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        Date date = null;
        try {
            date = sdf.parse(LANDING_DATE);
            date = DateUtils.addSeconds(date, sol1000);
            return sdf.format(date);
        } catch (ParseException e) {
            System.out.println("Could not calculate earth date");
            return LANDING_DATE;
        }

    }

}

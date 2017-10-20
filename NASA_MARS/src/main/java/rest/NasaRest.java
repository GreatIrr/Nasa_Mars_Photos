package rest;

import httpthings.AbstractRequest;
import httpthings.ResponseWrapper;
import untils.ProjectProperties;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class NasaRest {

    private static ProjectProperties projectProperties = ProjectProperties.getInstance();
    private static final String host = projectProperties.getProperty("rest.nasa");
    private static final String restApiKey = projectProperties.getProperty("rest.api.key");
    private static final String apiKey = projectProperties.getProperty("api.key");
    private static final String marsPhotos = projectProperties.getProperty("mars.1000.sol");
    private static final String page25 = projectProperties.getProperty("pages");

    public ResponseWrapper getTestApod() {
        System.out.println("the get request " + host + restApiKey + apiKey);
        return AbstractRequest.get(host + restApiKey + apiKey).sendAndGetResponse();
    }

    public ResponseWrapper getMars1000Sol() {
        System.out.println("request = " + marsPhotos  + restApiKey + apiKey);
        return AbstractRequest
                .get(marsPhotos  + restApiKey + apiKey)
                .sendAndGetResponse();
    }

    public ResponseWrapper sendCustomRequest(final String url) {
        System.out.println("Custom url = " + url);
        return AbstractRequest.get(url).sendAndGetResponse();
    }
}

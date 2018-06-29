package rest;

import annotations.Query;
import httpthings.AbstractRequest;
import httpthings.ResponseWrapper;
import untils.ProjectProperties;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Iryna_Bartnytska on 12/20/2017.
 */
public abstract class CommonRest {

    private static ProjectProperties projectProperties = ProjectProperties.getInstance();
    private static final String HOST = projectProperties.getProperty("rest.nasa");
    private static final String API_KEY = projectProperties.getProperty("api.key");
    private String url;


    String getHost() {
        return HOST;
    }

    String getApiKey() {
        return  API_KEY;
    }

    String getUrl() {
        return url;
    }

    private void setUrl(final String url) {
        this.url = url;
    }

    CommonRest() {



    }

    void testAnnotation(Method method, String... key) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getHost());
        BuildRequest buildRequest = new BuildRequest(method);
        stringBuilder.append(buildRequest.returnRequest(key));
        setUrl(stringBuilder.toString());
        System.out.println("url = " + getUrl());
    }

    ResponseWrapper sendAndGetResponce() {
        return AbstractRequest.get(url).sendAndGetResponse();
    }

}

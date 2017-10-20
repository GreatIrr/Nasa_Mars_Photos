package httpthings;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class AbstractRequest {

    private HttpRequestBase httpRequestBase;

    AbstractRequest(final String url, final HttpMethod httpMethod) {
        if(httpMethod.equals(HttpMethod.GET)) {
            httpRequestBase = new HttpGet(url);
        }
        if(httpMethod.equals(HttpMethod.POST)) {
            httpRequestBase = new HttpPost(url);
        }
        if(httpMethod.equals(HttpMethod.PUT)) {
            httpRequestBase = new HttpPut(url);
        }
    }

    public static AbstractRequest get(final String url) {
        return new AbstractRequest(url, HttpMethod.GET);
    }

    public static AbstractRequest put(final String url) {
        return new AbstractRequest(url, HttpMethod.PUT);
    }

    public static AbstractRequest post(final String url) {
        return new AbstractRequest(url, HttpMethod.POST);
    }

    public ResponseWrapper sendAndGetResponse() {
        ResponseWrapper responseWrapper = null;

        try {
            HttpResponse httpResponse = RestClient.getRestClient().execute(httpRequestBase);
            responseWrapper = new ResponseWrapper(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseWrapper;
    }

    public enum HttpMethod {
        GET, PUT, POST
    }

    public enum ContentType {
        APPLICATION_JSON("application/json;charset=utf-8");

        private String value;

        ContentType(final String value) {

            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

}

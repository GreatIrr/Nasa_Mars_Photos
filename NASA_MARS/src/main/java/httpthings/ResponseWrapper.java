package httpthings;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class ResponseWrapper {

    private int statusCode;
    private String body;
    private String bodyEncoded;
    private HttpResponse response;

    public ResponseWrapper(final HttpResponse httpResponse) {
        response = httpResponse;
        statusCode = httpResponse.getStatusLine().getStatusCode();
        try {
            bodyEncoded = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            body = new String(bodyEncoded.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBodyEncoded() {
        return bodyEncoded;
    }

    public HttpResponse getResponse() {
        return response;
    }
}

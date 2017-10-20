package httpthings;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class RestClient {

    private static CloseableHttpClient client;


    public static CloseableHttpClient getRestClient() {
        if(client == null) {
            client = defaultClient();
        }
        return client;
    }

    private static CloseableHttpClient defaultClient() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        return httpClient;
    }

}

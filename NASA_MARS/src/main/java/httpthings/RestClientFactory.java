package httpthings;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class RestClientFactory {

    private static RestClient restClient;

    public static RestClient getRestClient() {
        if(restClient == null) {
            restClient = newRestClient();
        }
        return restClient;
    }

    public static RestClient newRestClient() {
        return new RestClient();
    }

}

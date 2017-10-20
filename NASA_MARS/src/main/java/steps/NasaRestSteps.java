package steps;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import net.thucydides.core.annotations.Step;

import httpthings.ResponseWrapper;
import jsons.models.Mars;
import jsons.models.Photos;
import rest.NasaRest;
import rest.NasaRestPhotoParser;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class NasaRestSteps {

    private NasaRest nasaRest = new NasaRest();

    @Step
    public void sendRequestAndPrintBody() {
        ResponseWrapper responseWrapper = nasaRest.getTestApod();
        System.out.println(responseWrapper.getBody());
    }

    @Step
    public void getFirst10Ids() {
        ResponseWrapper responseWrapper = nasaRest.getMars1000Sol();
        String body = responseWrapper.getBody();
        Mars mars = NasaRestPhotoParser.parseNasaPhotoJson(body);
        System.out.println("Mars all list of photos=" + mars.getPhotos().size());
        List<Integer> ids = new LinkedList<>();
        for (Photos photo : mars.getPhotos()) {
            ids.add(photo.getId());
        }
        Collections.sort(ids);
        List<Integer> first10Ids = ids.subList(0, 9);
        System.out.println(Arrays.toString(first10Ids.toArray()));

    }

    @Step
    public void getPhotoMetaData(final String url) {
        ResponseWrapper responseWrapper = nasaRest.sendCustomRequest(url);
        System.out.println(responseWrapper.getBody());
    }


    private String getPhotoUrl(final Mars mars, final int id) {
        for(Photos photo : mars.getPhotos()) {
            if(photo.getId().equals(id)) {
                return photo.getImgSrc();
            }
        }
        return null;
    }
}

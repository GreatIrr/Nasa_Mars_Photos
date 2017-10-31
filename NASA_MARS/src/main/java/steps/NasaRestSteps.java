package steps;

import java.util.*;

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
    public void getFirst10SolIdsPhotoBody() {
        ResponseWrapper responseWrapper = nasaRest.getMars1000Sol();
        List<Integer> firstSolIds = getFirstN_ids(responseWrapper, 1);
        System.out.println("list of first ids = " + Arrays.toString(firstSolIds.toArray()));
    }


    @Step
    public void getFirst10EarthIdsPhotoBody() {
        ResponseWrapper responseWrapper = nasaRest.getMarsEarth1000Sol();
        List<Integer> firstSolIds = getFirstN_ids(responseWrapper, 1);
        System.out.println("list of first ids = " + Arrays.toString(firstSolIds.toArray()));
    }


    private Photos getPhotoInfo(final String body, final int id) {
        Mars mars = NasaRestPhotoParser.parseNasaPhotoJson(body);
        for(Photos photo : mars.getPhotos()) {
            if(photo.getId().equals(id)) {
                return photo;
            }
        }
        return null;
    }

    private List<Integer> getFirstN_ids(final ResponseWrapper responseWrapper, final int count) {
        String body = responseWrapper.getBody();
        Mars mars = NasaRestPhotoParser.parseNasaPhotoJson(body);
        System.out.println("Mars all list of photos=" + mars.getPhotos().size());
        List<Integer> ids = new LinkedList<>();
        for (Photos photo : mars.getPhotos()) {
            ids.add(photo.getId());
        }
        Collections.sort(ids);
        List<Integer> first10Ids = new ArrayList<>();
        if (count >= 0) {
           first10Ids = ids.subList(0, count);
        }
        return first10Ids;
    }
}

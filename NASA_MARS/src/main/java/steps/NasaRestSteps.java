package steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import net.javacrumbs.jsonunit.JsonAssert;
import net.thucydides.core.annotations.Step;

import httpthings.ResponseWrapper;
import jsons.models.Mars;
import jsons.models.Photos;
import rest.NasaRest;
import rest.NasaRestPhotoParser;
import session.Session;

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
    public void sendMarsSol(final int sol) {
        ResponseWrapper responseWrapper = nasaRest.getMarsNSol(sol);
        List<Integer> firstSolIds = getFirstN_ids(responseWrapper, 10); // hardcoded 10 elements
        for (int id : firstSolIds) {
            Photos photo = getPhotoInfo(responseWrapper.getBody(), id);
            Session.addMarsPhoto(photo);
        }
    }

    @Step
    public void sendEarthSol(final int sol) {
        ResponseWrapper responseWrapper = nasaRest.getMarsNSol(sol);
        List<Integer> firstSolIds = getFirstN_ids(responseWrapper, 10); // hardcoded 10 elements
        for (int id : firstSolIds) {
            Photos photo = getPhotoInfo(responseWrapper.getBody(), id);
            Session.addEarthPhoto(photo);
        }
    }

    @Step
    public void getAndCompareMarsAndEarthResponses() {
        List<Photos> marsPhotos = Session.getMarsPhotoList();
        List<Photos> earthPhotos = Session.getEarthPhotoList();
        String marsJsons = NasaRestPhotoParser.createJsonFromPhotoList(marsPhotos);
        String earthJsons = NasaRestPhotoParser.createJsonFromPhotoList(earthPhotos);
        JsonAssert.assertJsonEquals(marsJsons, earthJsons);
    }



    @Step
    public List<String> getFirst10SolIdsPhotoBody() {
        ResponseWrapper responseWrapper = nasaRest.getMarsNSol(1000);
        List<Integer> firstSolIds = getFirstN_ids(responseWrapper, 10); // hardcoded 10 elements
        System.out.println("list of first ids = " + Arrays.toString(firstSolIds.toArray()));
        List<String> result = new ArrayList<>();
        for (int id : firstSolIds) {
            Photos photo = getPhotoInfo(responseWrapper.getBody(), id);
            result.add(NasaRestPhotoParser.parseToString(photo));
        }
        return result;

    }





    @Step
    public List<String> getFirst10EarthIdsPhotoBody() {
        ResponseWrapper responseWrapper = nasaRest.getMarsEarth1000Sol();
        List<Integer> firstSolIds = getFirstN_ids(responseWrapper, 10); // hardcoded 10 elements
        System.out.println("list of first ids = " + Arrays.toString(firstSolIds.toArray()));
        List<String> result = new ArrayList<>();
        for (int id : firstSolIds) {
            Photos photo = getPhotoInfo(responseWrapper.getBody(), id);
            result.add(NasaRestPhotoParser.parseToString(photo));
        }
        return result;
    }

    @Step
    public void assertListOfPhotos(final List<String> marsPhotos, final List<String> earthPhotos) {
        String marsJsons = NasaRestPhotoParser.createJsonFromList(marsPhotos);
        String earthJsons = NasaRestPhotoParser.createJsonFromList(earthPhotos);
        JsonAssert.assertJsonEquals(marsJsons, earthJsons);
    }

    private Photos getPhotoInfo(final String body, final int id) {
        Mars mars = NasaRestPhotoParser.parseNasaPhotoJson(body);
        for (Photos photo : mars.getPhotos()) {
            if (photo.getId().equals(id)) {
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

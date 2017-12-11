package nasaTests;

import org.junit.Assert;
import org.junit.Test;
import steps.NasaRestSteps;

/**
 * Created by Iryna_Bartnytska on 10/14/2017.
 */
public class FirstNasaTest {

    private NasaRestSteps nasaRestSteps = new NasaRestSteps();

//    @Test
//    public void testPrintBody() {
//          nasaRestSteps.assertListOfPhotos(nasaRestSteps.getFirst10SolIdsPhotoBody(), nasaRestSteps.getFirst10EarthIdsPhotoBody());
//    }

    @Test
    public void startTest() {
        Assert.assertTrue("Does 1 == 2", 1 == 2);
    }
}

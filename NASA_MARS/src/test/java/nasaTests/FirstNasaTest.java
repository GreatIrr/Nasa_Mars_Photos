package nasaTests;

import org.junit.BeforeClass;
import org.junit.Test;
import steps.NasaRestSteps;
import untils.ProjectProperties;

/**
 * Created by Iryna_Bartnytska on 10/14/2017.
 */
public class FirstNasaTest {

    private NasaRestSteps nasaRestSteps = new NasaRestSteps();

    @Test
    public void testPrintBody() {
       // nasaRestSteps.sendRequestAndPrintBody();
        nasaRestSteps.getFirst10Ids();
    }
}

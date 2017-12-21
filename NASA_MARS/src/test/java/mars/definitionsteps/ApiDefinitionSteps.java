package mars.definitionsteps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import rest.NasaRest;
import ru.yandex.qatools.allure.annotations.Step;
import steps.NasaRestSteps;

/**
 * Created by Iryna_Bartnytska on 11/3/2017.
 */
public class ApiDefinitionSteps {

    @Steps
    private NasaRestSteps nasaRestSteps;

    @Given("User is a good guy")
    @Step
    public void userIsGood() {
        System.out.println("Starting test with good user");
    }

    @When("User sends Mars '$sol' Sol request and remembers Mars response")
    @Step
    public void userSendsAndRemembersMarsSol(final int sol) {
        nasaRestSteps.sendMarsSol(sol);
    }

    @When("User sends Earth '$sol' Sol request and remembers Earth response")
    @Step
    public void userSendsAndRemembersEarthSol(final int sol) {
        nasaRestSteps.sendEarthSol(sol);
    }

    @Then("User sees that Mars And Earth responses are equal")
    @Step
    public void userSeesThatMarsAndEarthResponsesAreEqual() {
        nasaRestSteps.getAndCompareMarsAndEarthResponses();
    }
}

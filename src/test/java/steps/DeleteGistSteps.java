package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.RestInterface;

public class DeleteGistSteps{
    private RestInterface restRequest;
    private SoftAssert softAssertion= new SoftAssert();
    private Response response;

    public DeleteGistSteps(){
        this.restRequest = new RestInterface();
    }

    @When("I delete the gist file")
    public void iDeleteTheGistFile() {
        response = restRequest.deleteRequest();
    }

    @Then("The gist file is deleted")
    public void theGistFileIsDeleted() {
        softAssertion.assertEquals(response.getStatusCode(),204);
        softAssertion.assertNotNull(response.asString());
        softAssertion.assertAll();
    }
}

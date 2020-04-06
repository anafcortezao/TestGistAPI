package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.RestInterface;

public class UpdateGistSteps{
    private RestInterface restRequest;
    private SoftAssert softAssertion= new SoftAssert();
    private Response response;
    private  String updateData;

    public UpdateGistSteps(){
        this.restRequest = new RestInterface();
    }

    @Given("I have a gist file")
    public void iHaveAGistFile() {
        updateData = "{\"description\": \"Assigment\",\"files\": {\"testes.txt\": {\"content\": \"Updated Tests\",\"filename\": \"testes.txt\"}}}";
    }

    @When("I update the gist file")
    public void iUpdateTheGistFile() {
        response = restRequest.patchRequest(updateData);
    }

    @Then("The gist file is updated")
    public void theGistFileIsUpdated() {
        softAssertion.assertEquals(response.getStatusCode(),200);
        softAssertion.assertNotNull(response.asString());
        softAssertion.assertAll();
    }
}

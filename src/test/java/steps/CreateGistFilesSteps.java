package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.Config;
import utils.RestInterface;

public class CreateGistFilesSteps extends Config{

    private RestInterface restRequest;
    private SoftAssert softAssertion= new SoftAssert();
    private Response response;
    private String fileData;

    public CreateGistFilesSteps(){
        this.restRequest = new RestInterface();
    }

    @Given("I want to create a gist file")
    public void iWantToCreateAGistFile() {
        fileData = "{\"description\": \"Tests1\",\"public\": true,\"files\": {\"testes5.txt\": {\"content\": \"Tests created file\"}}}";

    }

    @When("I add a new gist with files")
    public void iAddANewGistWithFiles() {

        response = restRequest.postRequest("/gists", fileData);
    }

    @Then("The gist with the files is created")
    public void theGistWithTheFilesIsCreated() {
        softAssertion.assertEquals(response.getStatusCode(),201);
        softAssertion.assertNotNull(response.asString());
        softAssertion.assertAll();
    }
}


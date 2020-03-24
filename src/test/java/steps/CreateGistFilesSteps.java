package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.Config;

public class CreateGistFilesSteps extends Config{

    //private RestInterface restRequest;
    private SoftAssert softAssertion= new SoftAssert();
    private Response response;

    @Given("I have a token")
    public void iHaveAToken() {

    }

    @When("I add a new gist with files")
    public void iAddANewGistWithFiles() {
        String payload = "{\"description\": \"Assigment3\",\"public\": true,\"files\": {\"testes3.txt\": {\"content\": \"Testes Aut para assigment\"}}}";

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .with()
                .body(payload)
                .when().post("/gists");

        //response = restRequest.postRequest(payload, "/gists");
    }

    @Then("The gist with the files is created")
    public void theGistWithTheFilesIsCreated() {
        softAssertion.assertEquals(response.getStatusCode(),200);
        softAssertion.assertNotNull(response.asString());
        softAssertion.assertAll();
    }
}


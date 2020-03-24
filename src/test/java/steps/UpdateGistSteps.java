package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.Config;

public class UpdateGistSteps extends Config {
    private SoftAssert softAssertion= new SoftAssert();
    private Response response;

    @Given("I have a gist")
    public void iHaveAGist() {
    }

    @When("I update the gist file")
    public void iUpdateTheGistFile() {
        String payload = "{\"description\": \"Assigment\",\"files\": {\"testes.txt\": {\"content\": \"Updated Test\",\"filename\": \"testes.txt\"}}}";
        RestAssured.baseURI = urlBase;

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .with()
                .body(payload)
                .when().patch("/gists/"+"5bd0375ed5a5a03c698a7b8f8fb3b738");
        System.out.println(response);
    }

    @Then("The gist file is updated")
    public void theGistFileIsUpdated() {
        softAssertion.assertEquals(response.getStatusCode(),200);
        softAssertion.assertNotNull(response.asString());
        softAssertion.assertAll();
    }
}

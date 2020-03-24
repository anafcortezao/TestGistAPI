package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.Config;

public class DeleteGistSteps extends Config {
    private SoftAssert softAssertion= new SoftAssert();
    private Response response;

    @When("I delete the gist file")
    public void iDeleteTheGistFile() {
        RestAssured.baseURI = urlBase;
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when().delete("/gists/"+"4febe38d94dd8ca5411f3d82aeca29a9");
    }

    @Then("The gist file is deleted")
    public void theGistFileIsDeleted() {
        softAssertion.assertEquals(response.getStatusCode(),204);
        softAssertion.assertNotNull(response.asString());
        softAssertion.assertAll();
    }
}

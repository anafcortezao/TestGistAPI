package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.RestInterface;


public class ListGistsSteps {
    private Response response;
    private String userName;
    private SoftAssert softAssertion= new SoftAssert();
    private RestInterface rest;

    public ListGistsSteps(){
        this.rest = new RestInterface();
    }

    @Given("I have an user")
    public void iHaveAnUser() {
        userName = "anafcortezao";
    }

    @When("I get a gists list for the user")
    public void iGetAGistsListForTheUser() {
        response = rest.getListGistsForUser(userName);
    }

    @Then("All public gists for the user are list")
    public void allPublicGistsForTheUserAreList() {
        softAssertion.assertEquals(response.getStatusCode(),200);
        softAssertion.assertNotNull(response.asString());
        softAssertion.assertAll();
    }


}

package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.Config;
import utils.RestInterface;

public class CreateAGist extends Config{
    private RestInterface rest;

    @Given("I have a token")
    public void iHaveAToken() {

    }

    @When("I add a new gist with files")
    public void iAddANewGistWithFiles() {
        String body = "{\"description\": \"Assigment2\",\"public\": true,\"files\": {\"testes2.txt\": {\"content\": \"Testes Aut para assigment\"}}}";
        Response response = rest.postRequest(token, body, "gists");
        System.out.println(response.asString());
    }

    @Then("The gist with the files is created")
    public void theGistWithTheFilesIsCreated() {
    }
}

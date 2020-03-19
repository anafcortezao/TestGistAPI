package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Config;
import utils.RestInterface;

import java.util.HashMap;

public class CreateAGist extends Config{
    private RestInterface rest;

    @Given("I have a token")
    public void iHaveAToken() {

    }

    @When("I add a new gist with files")
    public void iAddANewGistWithFiles() {
        RestAssured.baseURI = "https://api.github.com/";
        //RequestSpecification request = RestAssured.given();
        String payload = "{\"description\": \"Assigment2\",\"public\": true,\"files\": {\"testes2.txt\": {\"content\": \"Testes Aut para assigment\"}}}";
        Response response;

        response = RestAssured.given()
                    .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .with()
                    .body(payload)
                .when().post("/gists");

        //Response response = rest.postRequest(token, body, "gists");
        System.out.println(response.asString());
    }

    @Then("The gist with the files is created")
    public void theGistWithTheFilesIsCreated() {
    }
}

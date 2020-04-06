package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.*;

public class RestInterface extends Config{
    private Response response;


    public RestInterface(){
        RestAssured.baseURI = urlBase;
    }

    public Response postRequest(String path, String payload) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .with()
                .body(payload)
                .when().post(path);
        return response;
    }

    public Response getListGistsForUser() {
        response = RestAssured.get(RestAssured.baseURI +"users/"+userName+"/gists");
        return response;
    }

    public Response patchRequest(String payload){
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .with()
                .body(payload)
                .when().patch("/gists/"+"5bd0375ed5a5a03c698a7b8f8fb3b738");
        return response;
    }

}

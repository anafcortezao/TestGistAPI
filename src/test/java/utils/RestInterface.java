package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;

public class RestInterface extends Config{
    private Response response;
    private static RequestSpecification requestSpecification;

    public RestInterface(){

        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .setBaseUri(urlBase)
                .build();

    }

    public Response postRequest(String path, String payload) {
        response =
                RestAssured.given().
                        spec(requestSpecification).
                        auth().oauth2(token)
                .with()
                    .body(payload)
                .when()
                    .post(path);

        return response;
    }

    public Response getListGistsForUser() {
        response =
                RestAssured.given().
                    spec(requestSpecification).
                when().
                    get("users/"+userName+"/gists");
        return response;
    }

    public Response patchRequest(String payload){
        response =
                RestAssured.given().
                        spec(requestSpecification).
                        auth().oauth2(token).
                with().
                        body(payload).
                when().
                        patch("/gists/"+"5bd0375ed5a5a03c698a7b8f8fb3b738");
        return response;
    }

    public  Response deleteRequest(){
        response =
                RestAssured.given().
                        spec(requestSpecification).
                        auth().oauth2(token)
                .when().
                        delete("/gists/"+"daf1afc2f5f8d44d0d62865620fc1261");
        return response;
    }

}

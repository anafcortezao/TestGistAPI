package utils;

import io.cucumber.core.internal.gherkin.Parser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
/*import org.codehaus.groovy.ast.stmt.BreakStatement;
import io.restassured.specification.*;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.testng.Assert;*/

public class RestInterface extends Config{
    private Response response;


    public RestInterface(){
        RestAssured.baseURI = urlBase;
    }

    public Response postRequest(String bodyRequest,String path) {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.auth().oauth2(token);
        if (bodyRequest!=null){
            request.body(bodyRequest);
        }
        request.post(path);

        /*RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .with()
                .body(payload)
                .when().post("/gists");*/

        //response = request.post(RestAssured.baseURI+path);

        return response;
    }

    public Response getListGistsForUser(String user) {
        response = RestAssured.get(RestAssured.baseURI +"users/"+user+"/gists");
        return response;
    }

}

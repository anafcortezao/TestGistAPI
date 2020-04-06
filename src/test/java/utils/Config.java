package utils;

import io.restassured.RestAssured;


public class Config {
    //personal git token
    protected String token = "";

    //specified user to list gists
    protected String userName = "";

    //url base to do request on API
    protected String urlBase = "https://api.github.com/";
}

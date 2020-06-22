package ru.level.up.andrey.klementev.qa.homework_7.api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    static final String API_KEY = "c7a7abb843ab6a6c5d24b44c44c7bb8b";
    static final String TOKEN = "58d71f07d616a05a8112a90c332e2d6f646d9f704e9f767b379e004216acdd4a";


    @BeforeAll
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://api.trello.com/";
        RestAssured.requestSpecification = given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN);
        deleteAllBoardsTest();
    }


    public void deleteAllBoardsTest() {
        Response response = given().param("fields", "id").get("/1/members/me/boards").then().extract().response();
        List<String> jsonResponse = response.jsonPath().get("id");
        if (jsonResponse.toArray().length > 0)
            for (int i = 0; i < jsonResponse.toArray().length; i++) {
                given().delete(String.format("/1/boards/%s", jsonResponse.get(i)));
            }
    }

    public Response createBoard(String boardName) {
        Response response = given()
                .queryParam("name", boardName)
                .when()
                .contentType(ContentType.JSON)
                .request("POST", "/1/boards/");
        return response;
    }

    public String generateBoardName(){
        String boardName =  "Test board #" + new Random().nextInt(1000);
        return boardName;

    }

    public Response getBoardLists(Response createdBoard) {
        String idBoard = createdBoard.jsonPath().get("id");
        Response response = given()
                .when()
                .get("/1/boards/{idBoard}/lists", idBoard);
        return response;
    }

}

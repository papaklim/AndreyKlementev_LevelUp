package ru.level.up.andrey.klementev.qa.homework_7.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TrelloApiTesting extends BaseTest {

    @Test
    @Order(1)
    public void createBoardTest() {
        String generatedBoardName = generateBoardName();
        Response createdBoardResponse = createBoard(generatedBoardName);
        createdBoardResponse.then().assertThat().statusCode(200)
                .body("id", notNullValue())
                .body("name", equalTo(generatedBoardName));
    }

    @Test
    @Order(2)
    public void getCreatedBoardTest() {
        String generatedBoardName = generateBoardName();
        Response createdBoardResponse = createBoard(generatedBoardName);
        createdBoardResponse.then().assertThat().statusCode(200);
        String id = createdBoardResponse.jsonPath().get("id");
        Response getBoardResponse = given()
                .when()
                .param("fields", "name,url")
                .queryParam("id", id)
                .get("/1/members/me/boards/");
        getBoardResponse.then().assertThat()
                .statusCode(200);
    }

    @Test
    @Order(3)
    public void editCreatedBoardTest() {
        String generatedBoardName = generateBoardName();
        Response createdBoardResponse = createBoard(generatedBoardName);
        createdBoardResponse.then().assertThat().statusCode(200);
        String idBoard = createdBoardResponse.jsonPath().get("id");
        Response getBoardResponse = given()
                .when()
                .param("fields", "cards")
                .queryParam("id", idBoard)
                .get("/1/members/me/boards/");
        getBoardResponse.then().assertThat()
                .statusCode(200);
    }

    @Test
    @Order(4)
    public void getBoardListsTest() {
        String generatedBoardName = generateBoardName();
        Response createdBoardResponse = createBoard(generatedBoardName);
        createdBoardResponse.then().assertThat().statusCode(200);
        Response getBoardLists = getBoardLists(createdBoardResponse);
        getBoardLists.then().assertThat()
                .statusCode(200)
                .body("name[0]", equalTo("To Do"))
                .body("name[1]", equalTo("Doing"))
                .body("name[2]", equalTo("Done"));
    }

    @Test
    @Order(5)
    public void addCardToListTest() {
        Response createdBoardResponse = createBoard(generateBoardName());
        createdBoardResponse.then().assertThat().statusCode(200);
        Response getBoardListsResponse = getBoardLists(createdBoardResponse);
        getBoardListsResponse.then().assertThat().statusCode(200);
        for (int i = 0; i < getBoardListsResponse.jsonPath().getList("id").toArray().length; i++) {
            Response addCardToListResponse = given()
                    .when()
                    .contentType(ContentType.JSON)
                    .queryParam("name", "card for list: " + getBoardListsResponse.jsonPath().get(String.format("name[%s]", i)).toString())
                    .queryParam("idList", getBoardListsResponse.jsonPath().get(String.format("id[%s]", i)).toString())
                    .post("/1/cards");
            addCardToListResponse.then().assertThat()
                    .statusCode(200);
        }
    }

    @Test
    @Order(6)
    public void addListTest() {
        String generatedBoardName = generateBoardName();
        Response createdBoardResponse = createBoard(generatedBoardName);
        createdBoardResponse.then().assertThat().statusCode(200);
        Response addCardToListResponse = given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("name", "New List")
                .queryParam("pos", "bottom")
                .queryParam("idBoard", createdBoardResponse.jsonPath().get("id").toString())
                .post("/1/lists");
        addCardToListResponse.then().assertThat()
                .statusCode(200);

    }


    @Test
    @Order(7)
    public void createLabelTest() {
        String color = ColorLabel.values()[new Random().nextInt(ColorLabel.values().length)].color;
        String labelName = "New Label";
        String generatedBoardName = generateBoardName();
        Response createdBoardResponse = createBoard(generatedBoardName);
        String idBoard = createdBoardResponse.jsonPath().get("id").toString();
        createdBoardResponse.then().assertThat().statusCode(200);
        Response createLabelResponse = given()
                .when()
                .contentType(ContentType.JSON)
                .queryParam("name", labelName)
                .queryParam("color", color)
                .post("/1/boards/{id}/labels", idBoard);
        createLabelResponse.then().assertThat()
                .statusCode(200)
                .body("name", equalTo(labelName))
                .body("color", equalTo(color))
                .body("idBoard", equalTo(idBoard));
    }

    @Test
    @Order(8)
    public void createChecklistTest() {
        Response createdBoardResponse = createBoard(generateBoardName());
        createdBoardResponse.then().assertThat().statusCode(200);

    }

}

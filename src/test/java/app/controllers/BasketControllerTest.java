package app.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class BasketControllerTest {

    private static int createdBasketId;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:7070/api/baskets";
    }

    @Test
    void create() {
        String basketJson = """
        {
        }
        """;

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(basketJson)
                        .when()
                        .post()
                        .then()
                        .contentType(ContentType.JSON)
                        .statusCode(201)
                        .body("id", equalTo(1))
                        .extract().response();

        createdBasketId = response.path("id");
    }

    @Test
    void findById() {
        given()
                .pathParam("id", createdBasketId)
                .when()
                .get("/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(createdBasketId));
    }

    @Test
    void update() {
        String updatedHotelJson = """
        {
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", createdBasketId)
                .body(updatedHotelJson)
                .when()
                .put("/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    void delete() {
        given()
                .pathParam("id", createdBasketId)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(200)
                .body(containsString("deleted"));
    }
}
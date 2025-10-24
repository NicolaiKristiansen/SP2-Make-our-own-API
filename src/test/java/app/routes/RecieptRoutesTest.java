package app.routes;

import app.Category;
import app.config.HibernateConfig;
import app.dao.ProductDAO;
import app.entities.Product;
import io.javalin.http.HttpStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RecieptRoutesTest {

    static int createdBasketId;

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 7070;
        RestAssured.basePath = "/api/receipt";
    }

    @Test
    void getAll(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/")
                .then()
                .statusCode(200);
    }

    @Test
    void getById(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }
}
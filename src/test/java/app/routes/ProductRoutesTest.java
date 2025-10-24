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
class ProductRoutesTest {
    static int createdProductId;

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 7070;
        RestAssured.basePath = "/api/products";
    }

    @Test
    @Order(1)
    void createProduct() {
        String json = """
                    {
                        "name": "Test Product",
                        "price": 10.50,
                        "category": "ELECTRONICS"
                    }
                """;

        ValidatableResponse response= given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("name", equalTo("Test Product"))
                .body("price", equalTo(10.50f));

        createdProductId = response.extract().path("id");
        //Test if the product created works
    }

    @Test
    @Order(2)
    void findById(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/" + createdProductId)
                .then()
                .statusCode(200)
                .body("id", equalTo(createdProductId))
                .body("name", equalTo("Test Product"));
        //You can guess what this should do
    }

    @Test
    @Order(3)
    void getAll(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(1));
    }

    @Test
    @Order(4)
    void update(){
        String json = """
                {
                    "name": "Updated Product",
                    "price": 20.40,
                    "category": "MEDICIN"
                }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .put("/" + createdProductId)
                .then()
                .statusCode(200)
                .body("name", equalTo("Updated Product"))
                .body("price", equalTo(20.40f))
                .body("category", equalTo("MEDICIN"));
        //Is it updated
    }

    @Test
    @Order(5)
    void delete(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/" + createdProductId)
                .then()
                .statusCode(200);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/" + createdProductId)
                .then()
                .statusCode(404);
        //How to see if the product has been deleted
    }
}
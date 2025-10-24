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
class BasketRoutesTest {
    static int createdBasketId;
    
    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 7070;
        RestAssured.basePath = "/api/baskets";
    }

    @Test
    @Order(1)
    void createProduct() {
        ValidatableResponse response= given()
                .contentType(ContentType.JSON)
                .body("{}")
                .when()
                .post("/")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("products", notNullValue());

        createdBasketId = response.extract().path("id");
    }

    @Test
    @Order(2)
    void findById(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/" + createdBasketId)
                .then()
                .statusCode(200)
                .body("id", equalTo(createdBasketId));
    }

    @Test
    @Order(3)
    void update(){
        String json = """
                {
                      "id": 1,
                      "products": [
                        {
                          "id": 1,
                          "name": "Crease 3XP digital pen",
                          "price": 200.0,
                          "category": "ELECTRONICS"
                        },
                        {
                          "id": 2,
                          "name": "Milk",
                          "price": 18.0,
                          "category": "FOOD"
                        }
                      ],
                      "receipt": null
                    }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .put("/" + createdBasketId)
                .then()
                .statusCode(200)
                .body("products.size()", greaterThanOrEqualTo(2));
        //Is it updated
    }

    @Test
    @Order(5)
    void delete(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/" + createdBasketId)
                .then()
                .statusCode(200);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/" + createdBasketId)
                .then()
                .statusCode(404);
    }

    @Test
    @Order(4)
    void addProductToBasket(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .put("/" + createdBasketId + "/product/1")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(1));
    }


}
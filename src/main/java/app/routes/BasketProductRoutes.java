package app.routes;

import app.controllers.BasketController;
import app.controllers.BasketProductController;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class BasketProductRoutes {
    BasketProductController basketProductController = new BasketProductController();

    public EndpointGroup getRoutes() {
        return () -> {
            get("/{id}", basketProductController::getProductsFromBasket);
            /*
            post("/", basketController::createBasket);
            put("/", basketController::updateBasket);
            delete("/{id}", basketController::deleteBasket);
            put("/{basket_id}/product/{product_id}", basketController::addProduct);

             */
        };
    }
}

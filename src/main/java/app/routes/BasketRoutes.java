package app.routes;

import app.controllers.BasketController;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.delete;

public class BasketRoutes {
    BasketController basketController = new BasketController();

    public EndpointGroup getRoutes() {
        return () -> {
            get("/{id}", basketController::getBasketById);
            post("/", basketController::createBasket);
            put("/{id}", basketController::updateBasket);
            delete("/{id}", basketController::deleteBasket);
        };
    }
}

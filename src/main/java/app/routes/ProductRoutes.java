package app.routes;

import app.controllers.ProductController;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ProductRoutes {
    ProductController controller = new ProductController();
/*
    public EndpointGroup getRoutes(){
        return () -> {
            post("/", controller::create);
            get("/{id}", controller::findByID);
            get("/", controller::getAll);
            put("/{id}", controller::update);
            delete("/{id}", controller::delete);
        };
    }

 */
}

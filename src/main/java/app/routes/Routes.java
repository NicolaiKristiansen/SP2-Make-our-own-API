package app.routes;

import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class Routes {

    private BasketRoutes basketRoutes = new BasketRoutes();

    public EndpointGroup getRoutes() {
        return () -> {
            get("/", ctx -> ctx.result("Hello World"));
            path("/baskets", basketRoutes.getRoutes());
        };
    }
}

package app.routes;

import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class Routes {
    RecieptRoutes recieptRoutes = new RecieptRoutes();
    public EndpointGroup getRoutes(){
        return () -> {
            get("/", ctx -> ctx.result("Hello World"));
            path("/receipt", recieptRoutes.getRoutes());
        };
    }
}

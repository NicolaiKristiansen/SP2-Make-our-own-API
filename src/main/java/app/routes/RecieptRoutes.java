package app.routes;

import app.controllers.ReceiptController;
import io.javalin.apibuilder.EndpointGroup;
import static io.javalin.apibuilder.ApiBuilder.*;

public class RecieptRoutes {
ReceiptController receiptController = new ReceiptController();
    public EndpointGroup getRoutes(){
        return () -> {
          get("/", receiptController::getAll);
          get("/{id}", receiptController::getReceipt);
        };
    }
}

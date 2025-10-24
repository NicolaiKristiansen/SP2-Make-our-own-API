package app.controllers;

import app.config.HibernateConfig;
import app.dao.BasketDAO;
import app.dao.BasketProductDAO;
import app.dao.ProductDAO;
import app.dto.basket_product.BasketProductDTO;
import app.dto.basket_product.BasketProductResponseDTO;
import app.dto.product.ProductDTO;
import app.dto.product.ProductsResponseDTO;
import app.entities.BasketProduct;
import app.entities.Product;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BasketProductController {
    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    private BasketProductDAO basketProductDAO = new BasketProductDAO(emf);
    private BasketDAO basketDAO = new BasketDAO(emf);

    private static final Logger logger = LoggerFactory.getLogger(BasketController.class);
    private static final Logger debugLogger = LoggerFactory.getLogger("app");


    public void getProductsFromBasket(Context ctx) {
        try {
            Integer id = Integer.parseInt(ctx.pathParam("id"));
            List<BasketProduct> basketProducts = basketDAO.getProductsFromBasket(id);

            List<BasketProductDTO> basketProductDTOList = basketProducts.stream()
                    .map(basketProduct -> new BasketProductDTO(
                            basketProduct.getId(),
                            basketProduct.getBasket().getId(),
                            basketProduct.getProduct().getName(),
                            basketProduct.getAmount()
                    ))
                    .collect(Collectors.toList());

            BasketProductResponseDTO responseDTO = new BasketProductResponseDTO(basketProductDTOList);

            ctx.status(HttpStatus.OK);
            ctx.json(responseDTO);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR).result("Kunne ikke hente produkter");
        }
    }
}

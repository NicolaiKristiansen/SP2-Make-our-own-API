package app.controllers;

import app.config.HibernateConfig;
import app.daos.BasketDAO;
import app.daos.BasketProductDAO;
import app.daos.ProductDAO;
import app.dtos.basket.BasketRequestDTO;
import app.entities.Basket;
import app.entities.BasketProduct;
import app.entities.Product;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityManagerFactory;

public class BasketController {
    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    private BasketDAO basketDAO = new BasketDAO(emf);
    private ProductDAO productDAO = new ProductDAO(emf);
    private BasketProductDAO basketProductDAO = new BasketProductDAO(emf);

    public void addProductToBasket(Context ctx) {
        BasketRequestDTO dto = ctx.bodyAsClass(BasketRequestDTO.class);
        Basket basket = basketDAO.findById(dto.getBasketId());

        if(basket == null) {
            basket = basketDAO.create(new Basket());
        }

        Product product = productDAO.findById(dto.getProductId());
        BasketProduct basketProduct = new BasketProduct(basket, product, dto.getAmount());

        basketProductDAO.create(basketProduct);
        ctx.status(HttpStatus.OK);
    }
}

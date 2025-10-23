package app.controllers;

import app.config.HibernateConfig;
import app.dao.BasketDAO;
import app.dao.BasketProductDAO;
import app.dao.ProductDAO;
import app.dto.BasketRequestDTO;
import app.entities.Basket;
import app.entities.BasketProduct;
import app.entities.Product;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketController {
    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    private BasketDAO basketDAO = new BasketDAO(emf);
    private ProductDAO productDAO = new ProductDAO(emf);
    private BasketProductDAO basketProductDAO = new BasketProductDAO(emf);

    private static final Logger logger = LoggerFactory.getLogger(BasketController.class);
    private static final Logger debugLogger = LoggerFactory.getLogger("app");
/*
    public void createBasket(Context ctx) {
        try {
            BasketDTO basketDTO = ctx.bodyAsClass(BasketDTO.class);
            Basket basket = basketDAO.create(basketDTO);
            BasketDTO newBasketDTO = new BasketDTO(basket);
            ctx.status(HttpStatus.CREATED);
            ctx.json(newBasketDTO);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            ctx.status(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error(e.getMessage());
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 */
/*
    public void getBasketById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Basket basket = basketDAO.findById(id);
        BasketDTO basketDTO = new BasketDTO(basket);
        ctx.status(HttpStatus.OK);
        ctx.json(basketDTO);
        logger.info("Fetched basket with id: " + id);
    }

 */
/*
    public void updateBasket(Context ctx) {

        BasketUpdateDTO dto = ctx.bodyAsClass(BasketUpdateDTO.class);
        Basket basket = new Basket(
                dto.getId(),
                dto.getProductIds(),
                dto.getAmount()
        );

        basket.setId(basketUpdateDTO.getId());
        bask

        Basket basket = basketDAO.update(basketDTO, id);
        basketDTO = new BasketDTO(basket);
        ctx.status(HttpStatus.OK);
        ctx.json(basketDTO);


    }

 */
/*
    public void deleteBasket(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        basketDAO.delete(id);
        ctx.result("Basket with id " + id + " deleted");
    }

 */


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

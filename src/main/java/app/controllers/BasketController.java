package app.controllers;

import app.config.HibernateConfig;
import app.dao.BasketDAO;
import app.dto.BasketDTO;
import app.entities.Basket;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketController {
    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    BasketDAO basketDAO = new BasketDAO(emf);

    private static final Logger logger = LoggerFactory.getLogger(BasketController.class);
    private static final Logger debugLogger = LoggerFactory.getLogger("app");

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

    public void getBasketById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Basket basket = basketDAO.findById(id);
        BasketDTO basketDTO = new BasketDTO(basket);
        if (basketDTO != null) {
            ctx.status(HttpStatus.OK);
            ctx.json(basketDTO);
            logger.info("Fetched basket with id: " + id);
        } else {
            ctx.status(HttpStatus.NOT_FOUND);
            ctx.result("Basket not found");
            logger.warn("Basket with id " + id + " not found");
        }
    }

    public void updateBasket(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        BasketDTO basketDTO = ctx.bodyAsClass(BasketDTO.class);
        Basket basket = basketDAO.update(basketDTO, id);
        basketDTO = new BasketDTO(basket);
        ctx.status(HttpStatus.OK);
        ctx.json(basketDTO);
    }

    public void deleteBasket(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        basketDAO.delete(id);
        ctx.result("Basket with id " + id + " deleted");
    }
}

package app.dao;

import app.dto.BasketDTO;
import app.entities.Basket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class BasketDAO implements IDAO<Basket, BasketDTO> {
    EntityManagerFactory emf;

    public BasketDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Basket create(BasketDTO basketDTO) {
        Basket basket = new Basket(basketDTO);
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(basket);
            em.getTransaction().commit();
        }
        return basket;
    }

    @Override
    public Basket findById(int id) {

        try(EntityManager em = emf.createEntityManager()) {
            Basket basket = em.find(Basket.class, id);
            if (basket != null) {
                return basket;
            } else {
                return null;
            }
        }
    }

    @Override
    public Basket update(BasketDTO basketDTO, Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Basket b = em.find(Basket.class, id);
            b.setId(basketDTO.getId());
            b.setProducts(basketDTO.getProducts());
            b.setReceipt(basketDTO.getReceipt());
            Basket mergedBasket = em.merge(b);
            em.getTransaction().commit();
            return mergedBasket;
        }
    }

    @Override
    public void delete(int id) {
        try(EntityManager em = emf.createEntityManager()) {
            Basket deleteBasket = em.find(Basket.class, id);
            em.getTransaction().begin();
            em.remove(deleteBasket);
            em.getTransaction().commit();
        }
    }
}

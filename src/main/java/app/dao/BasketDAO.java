package app.dao;

import app.config.HibernateConfig;
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
        Basket basket;
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            basket = em.find(Basket.class, id);
            em.getTransaction().commit();
        }
        return basket;
    }

    @Override
    public Basket update(Integer integer, BasketDTO basketDTO) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Basket b = em.find(Basket.class, integer);
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
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        }
    }
}

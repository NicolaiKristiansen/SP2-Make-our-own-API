package app.dao;

import app.entities.BasketProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class BasketProductDAO implements IDAO<BasketProduct, Integer> {
    private EntityManagerFactory emf;

    public BasketProductDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public BasketProduct create(BasketProduct basketProduct) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(basketProduct);
            em.getTransaction().commit();
            return basketProduct;
        }
    }

    @Override
    public BasketProduct findById(Integer id) {
        return null;
    }

    @Override
    public BasketProduct update(BasketProduct basketProduct, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}

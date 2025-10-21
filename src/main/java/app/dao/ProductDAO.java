package app.dao;

import app.dto.ProductDTO;
import app.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ProductDAO implements IDAO<Product, ProductDTO>{

    private EntityManagerFactory emf;

    public ProductDAO (EntityManagerFactory emf){
        this.emf = emf;
    }


    @Override
    public Product create(ProductDTO o) {
        try(EntityManager em = emf.createEntityManager()){

        }
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product update(ProductDTO o) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

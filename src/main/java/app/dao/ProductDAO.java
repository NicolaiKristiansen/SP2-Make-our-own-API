package app.dao;

import app.dto.ProductDTO;
import app.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;


public class ProductDAO implements IDAO<Product, ProductDTO>{

    private EntityManagerFactory emf;

    public ProductDAO (EntityManagerFactory emf){
        this.emf = emf;
    }


    @Override
    public Product create(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        try(EntityManager em = emf.createEntityManager()){
            EntityTransaction ts = em.getTransaction();
            ts.begin();
            em.persist(product);
            ts.commit();

            return product;
        }
    }

    @Override
    public Product findById(int id) {
        try(EntityManager em = emf.createEntityManager()) {
            Product product = em.find(Product.class, id);
            if(product != null) {
                return product;
            }
            else System.out.println("The product could not be found and has returned a null");
        }
        return null;
    }

    @Override
    public Product update(ProductDTO productDTO, Integer id) {
        try(EntityManager em = emf.createEntityManager()){
            EntityTransaction ts = em.getTransaction();
            ts.begin();
            Product found = em.find(Product.class, id);

        }
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

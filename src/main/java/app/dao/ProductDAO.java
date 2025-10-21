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
            found.setName(productDTO.getName());
            found.setPrice(productDTO.getPrice());
            found.setCategory(productDTO.getCategory());

            Product product = em.merge(found);
            if(product.getName() == productDTO.getName() && product.getPrice() == productDTO.getPrice() && product.getCategory() == productDTO.getCategory()){
                return product;
            } else{
                System.out.println("We could not update the products as one of the variable does not contain the new information");
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try(EntityManager em = emf.createEntityManager()){
            EntityTransaction ts = em.getTransaction();
            ts.begin();
            Product product = findById(id);
            em.remove(product);
            ts.commit();

            if(findById(id) == null){
                System.out.println("The product has been deleted");
            }
        }

    }
}

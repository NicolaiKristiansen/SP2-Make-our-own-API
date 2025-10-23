package app.dao;

import app.dto.ProductDTO;
import app.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;


public class ProductDAO implements IDAO<Product, Integer>{

    private EntityManagerFactory emf;

    public ProductDAO (EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public Product create(Product product) {
        try(EntityManager em = emf.createEntityManager()){
            EntityTransaction ts = em.getTransaction();
            ts.begin();
            em.persist(product);
            ts.commit();
            return product;
        }
    }

    @Override
    public Product findById(Integer id) {
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
    public Product update(Product product, Integer id) {
        try(EntityManager em = emf.createEntityManager()){
            EntityTransaction ts = em.getTransaction();
            ts.begin();
            Product found = em.find(Product.class, id);
            found.setName(product.getName());
            found.setPrice(product.getPrice());
            found.setCategory(product.getCategory());

            Product newProduct = em.merge(found);
            if(product.getName() == newProduct.getName() && product.getPrice() == newProduct.getPrice() && product.getCategory() == newProduct.getCategory()){
                return product;
            } else{
                System.out.println("We could not update the products as one of the variable does not contain the new information");
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
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

/*
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

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            TypedQuery<Product> query= em.createQuery("select p from Product p", Product.class);
            products = query.getResultList();

            return products;
        }
    }

 */
}

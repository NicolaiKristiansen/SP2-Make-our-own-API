package app.dao;

import app.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;


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
            if (product != null) {
                return product;
            } else {
                return null;
            }
        }
    }

    @Override
    public Product update(Product product, Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Product updatedProduct = em.find(Product.class, id);
            updatedProduct.setId(product.getId());
            updatedProduct.setName(product.getName());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setCategory(product.getCategory());
            Product mergedProduct = em.merge(updatedProduct);
            em.getTransaction().commit();
            return mergedProduct;
        }
    }

    @Override
    public void delete(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            Product deleteProduct = em.find(Product.class, id);
            em.getTransaction().begin();
            em.remove(deleteProduct);
            em.getTransaction().commit();
        }
    }
    /*

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

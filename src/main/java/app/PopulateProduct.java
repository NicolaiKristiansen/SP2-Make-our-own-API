package app;

import app.config.HibernateConfig;
import app.dao.ProductDAO;
import app.enums.Category;
import app.dto.ProductDTO;

import java.util.ArrayList;

public class PopulateProduct {

    private static ArrayList<ProductDTO> products = new ArrayList<>();

    public static void main(String[] args){
        ProductDTO product1 = new ProductDTO("Crease 3XP digital pen", 200.00, Category.ELECTRONICS);
        ProductDTO product2 = new ProductDTO("Milk", 18.00, Category.FOOD);
        ProductDTO product3 = new ProductDTO("Wacom XL Gen3 drawing tablet", 1800.00, Category.ELECTRONICS);
        ProductDTO product4 = new ProductDTO("Bread Bundle", 54.00, Category.FOOD);
        ProductDTO product5 = new ProductDTO("Chair", 200.00, Category.FUNATURE);
        ProductDTO product6 = new ProductDTO("Table", 500.00, Category.FUNATURE);
        ProductDTO product7 = new ProductDTO("Sofa", 700.00, Category.FUNATURE);


        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);

        ProductDAO dao = new ProductDAO(HibernateConfig.getEntityManagerFactory());

       for (ProductDTO productDTO: products){
           dao.create(productDTO);
       }
    }
}

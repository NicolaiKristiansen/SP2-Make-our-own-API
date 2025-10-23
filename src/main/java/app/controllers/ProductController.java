package app.controllers;

import app.config.HibernateConfig;
import app.dao.ProductDAO;
import app.dto.ProductDTO;
import app.entities.Product;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    private final ProductDAO dao = new ProductDAO(emf);

    /*

        public void create(Context ctx){
            try {
                ProductDTO productDTO = ctx.bodyAsClass(ProductDTO.class);
                Product createdProduct = dao.create(productDTO);

                ctx.status(HttpStatus.OK).json(createdProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void findByID(Context ctx){
            try {
                Integer integer = Integer.parseInt(ctx.pathParam("id"));
                Product product = dao.findById(integer);
                if (product == null) {
                    ctx.status(HttpStatus.NOT_FOUND).result("Product not found");
                } else {
                    ctx.status(HttpStatus.OK).json(product);
                }
            }catch (NumberFormatException numberError){
                ctx.status(HttpStatus.BAD_REQUEST).result("Invalid product id");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public void update(Context ctx){
            try{
            Integer i = Integer.parseInt(ctx.pathParam("id"));
            ProductDTO productDTO = ctx.bodyAsClass(ProductDTO.class);

            Product product = dao.update(productDTO, i);

            if (product == null) {
                ctx.status(HttpStatus.NOT_FOUND).result("Product not found or not updated");
            } else {
                ctx.status(HttpStatus.OK).json(product);
            }
        } catch (Exception e) {
        e.printStackTrace();
            }
        }

        public void delete(Context ctx){
            try {
                Integer i = Integer.parseInt(ctx.pathParam("id"));
                dao.delete(i);
                ctx.status(HttpStatus.OK).result("The product has been deleted");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public void getAll(Context ctx){
            try{
                List<Product> products = new ArrayList<>();
                products = dao.getAllProducts();

                ctx.status(HttpStatus.OK).json(products);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

     */
}

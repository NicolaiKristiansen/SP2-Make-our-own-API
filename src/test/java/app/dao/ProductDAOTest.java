package app.dao;

import app.enums.Category;
import app.config.HibernateConfig;
import app.dto.ProductDTO;
import app.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductDAOTest {
    private ProductDAO dao;

    @BeforeEach
    void setUp() {
        dao = new ProductDAO(HibernateConfig.getEntityManagerFactoryForTest());
    }

    @Test
    @Order(1)
    void create() {
        ProductDTO productDTO = new ProductDTO("Test Object", 2000, Category.ELECTRONICS);
        Product product = dao.create(productDTO);

        assertEquals(product.getName(), productDTO.getName());
        assertEquals(product.getPrice(), productDTO.getPrice());
        assertEquals(product.getCategory(), productDTO.getCategory());
    }

    @Test
    @Order(2)
    void findById() {
        ProductDTO expected = new ProductDTO("Crease 3XP digital pen", 200.00, Category.ELECTRONICS);
        Product created = dao.create(expected);
        Product actual = dao.findById(created.getId());


        assertEquals(created.getName(), actual.getName());
        assertEquals(created.getPrice(), actual.getPrice());
        assertEquals(created.getCategory(), actual.getCategory());
    }

    @Test
    @Order(3)
    void update() {
        ProductDTO originalDTO = new ProductDTO("Old Name", 50.0, Category.FUNATURE);
        Product original = dao.create(originalDTO);

        ProductDTO updatedDTO = new ProductDTO("New Name", 75.0, Category.ELECTRONICS);
        Product updated = dao.update(updatedDTO, original.getId());

        assertEquals("New Name", updated.getName());
    }

    @Test
    @Order(4)
    void delete() {
        ProductDTO dto = new ProductDTO("Delete Me", 10.0, Category.FOOD);
        Product product = dao.create(dto);

        dao.delete(product.getId());

        Product found = dao.findById(product.getId());
        assertNull(found);
    }
}
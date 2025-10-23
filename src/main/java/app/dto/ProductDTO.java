package app.dto;

import app.enums.Category;
import app.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private Category category;

    public ProductDTO (String name, double price, Category category){
        this.name = name;
        this.price = price;
        this.category = category;
    }


    public ProductDTO (int id, String name, double price, Category category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }
}

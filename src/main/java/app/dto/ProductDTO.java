package app.dto;

import app.Category;
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
}

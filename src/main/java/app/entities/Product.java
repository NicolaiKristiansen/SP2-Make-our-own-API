package app.entities;

import app.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import app.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private Category category;

    @ManyToOne
    @JoinColumn (name = "products")
    @JsonIgnoreProperties
    private Basket basket;

    public Product(int id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(ProductDTO productDTO){
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.category = productDTO.getCategory();
    }
}

package app.entities;

import app.enums.Category;
import app.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JsonIgnore
    private List<Basket> basket = new ArrayList<>();

    public Product(int id, String name, double price, Category category, List<Basket> basket) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.basket = basket;
    }

    public Product(String name, double price, Category category, List<Basket> basket) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.basket = basket;
    }

    //TODO basketDTO convert to basket but it's a list.
    public Product(ProductDTO productDTO){
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.category = productDTO.getCategory();
    }
}

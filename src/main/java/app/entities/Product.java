package app.entities;

import app.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import app.Category;
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
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("products")
    private List<Basket> baskets = new ArrayList<>();

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

    public void addBasket(Basket basket) {
        this.baskets.add(basket);
        basket.getProducts().add(this);
    }

}

package app.entities;

import app.dto.BasketDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "basket", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    @OneToOne
    private Receipt receipt;

    public Basket(int id, List<Product> products, Receipt receipt) {
        this.id = id;
        this.products = products;
        this.receipt = receipt;
    }

    //TODO Entity to DTO
    //TODO all test

    public Basket(BasketDTO basketDTO) {
        this.id = basketDTO.getId();
      //  this.products = basketDTO.getProducts();
       // this.receipt = basketDTO.getReceipt();
    }



    public void addProduct(Product product) {
        if(product != null) {
            this.products.add(product);
        } else {
            System.out.println("Could not find product");
        }
    }
}
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

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    @OneToOne
    private Receipt receipt;

    public Basket(int id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Basket(BasketDTO basketDTO) {
        this.id = basketDTO.getId();
        this.products = basketDTO.getProducts();
    }
}
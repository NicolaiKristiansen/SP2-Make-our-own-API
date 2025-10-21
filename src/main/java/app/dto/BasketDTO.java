package app.dto;

import app.entities.Basket;
import app.entities.Product;
import app.entities.Receipt;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class BasketDTO {
    private int id;
    private List<Product> products = new ArrayList<>();
    private Receipt receipt;

    public BasketDTO(int id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public BasketDTO(Basket basket) {
        this.id = basket.getId();
        this.products = basket.getProducts();
    }
}
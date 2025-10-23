package app.dto;

import app.entities.Basket;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketResponseDTO {
    private int id;
    private List<Integer> productIds;
    private int receiptId;

    public BasketResponseDTO(List<Integer> products, int receipt) {
        this.productIds = products;
        this.receiptId = receipt;
    }

    public BasketResponseDTO(int id, List<Integer> products, int receipt) {
        this.id = id;
        this.productIds = products;
        this.receiptId = receipt;
    }

    public BasketResponseDTO(Basket basket) {
        this.id = basket.getId();
        //this.products = basket.getProducts();
       // this.receipt = basket.getReceipt();
    }


}
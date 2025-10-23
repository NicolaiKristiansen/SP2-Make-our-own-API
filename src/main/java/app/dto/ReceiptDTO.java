package app.dto;


import app.entities.Receipt;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiptDTO {
    public int id;
    public double totalPrice;
    public int basketId;

    public ReceiptDTO(double totalPrice, int basketId) {
        this.totalPrice = totalPrice;
        this.basketId = basketId;
    }

    public ReceiptDTO(int id, double totalPrice, int basketId){
        this.id = id;
        this.totalPrice = totalPrice;
        this.basketId = basketId;
    }

    public ReceiptDTO(Receipt receipt){
        this.id = receipt.getId();
        this.totalPrice = receipt.getTotalPrice();
        this.basketId = receipt.getBasket().getId();
    }

}

package app.dto;


import app.entities.Receipt;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReceiptDTO {

    public int id;
    public double totalPrice;
    public int basketId;


    public ReceiptDTO(Receipt receipt){
        this.id = receipt.getId();
        this.totalPrice = receipt.getTotal_price();
        this.basketId = receipt.getBasket().getId();
    }
}

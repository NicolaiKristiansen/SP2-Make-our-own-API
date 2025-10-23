package app.dto;


import app.entities.Receipt;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

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
        this.totalPrice = receipt.getTotalPrice();
        this.basketId = receipt.getBasket().getId();
    }


    public static List<ReceiptDTO> toDTOlist(List<Receipt> ResultReceipts){
        return ResultReceipts.stream().map(ReceiptDTO::new).toList();
    }
}

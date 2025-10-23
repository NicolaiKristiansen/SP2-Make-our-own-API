package app.entities;


import app.dto.ReceiptDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public double totalPrice;


    @OneToOne
    public Basket basket;

    public Receipt(ReceiptDTO dto){
        this.id = dto.getId();
        this.totalPrice = dto.getTotalPrice();
        if(dto.getBasketId() != 0) {
            Basket b = new Basket();
            b.setId(dto.getBasketId()); // sæt kun ID
            this.basket = b;
        }
    }

}

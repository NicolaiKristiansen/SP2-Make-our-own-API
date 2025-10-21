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

    public double total_price;


    @OneToOne
    @JoinColumn(name = "basket_id")
    public Basket basket;

    public Receipt(ReceiptDTO dto){
        this.id = dto.getId();
        this.total_price = dto.getTotalPrice();
        this.basket = dto.getBasket();
    }

}

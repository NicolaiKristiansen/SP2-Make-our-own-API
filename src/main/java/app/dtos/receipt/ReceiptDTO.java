package app.dtos.receipt;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiptDTO {
    public int id;
    public double totalPrice;
    public int basketId;
}

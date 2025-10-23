package app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketUpdateDTO {
    private int id;
    private int productIds;
    private int amount;


    public BasketUpdateDTO(int id, int productIds, int amount) {
        this.id = id;
        this.productIds = productIds;
        this.amount = amount;
    }
}
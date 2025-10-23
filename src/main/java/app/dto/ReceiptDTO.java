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
}

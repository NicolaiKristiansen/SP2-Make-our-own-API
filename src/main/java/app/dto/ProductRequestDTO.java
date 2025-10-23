package app.dto;

import app.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDTO {
    private String name;
    private double price;
    private Category category;

}

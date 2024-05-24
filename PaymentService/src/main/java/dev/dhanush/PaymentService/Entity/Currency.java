package dev.dhanush.PaymentService.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Currency extends BaseModel{
    private String currencyTag; // "INR", "USD", "NPR", "GBP", "EUR"
    private String currencyName; // "Indian Rupees", "United States Dollar
    private String country;
}
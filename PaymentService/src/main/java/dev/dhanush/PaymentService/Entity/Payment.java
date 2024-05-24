package dev.dhanush.PaymentService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;
import java.util.UUID;
@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private double amount;
    private UUID userId;
    private UUID orderId;
    private String transactionId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @OneToOne
    private Currency currency;
}
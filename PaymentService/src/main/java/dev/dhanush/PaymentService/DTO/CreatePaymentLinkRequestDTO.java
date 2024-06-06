package dev.dhanush.PaymentService.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreatePaymentLinkRequestDTO {
    private double amount;
    private UUID orderId;
    private String name;
    private String contact;
    private String email;
    private String description;
}

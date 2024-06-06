package dev.dhanush.PaymentService.PaymentGateway;


import dev.dhanush.PaymentService.Entity.PaymentStatus;

import java.util.UUID;

public interface PaymentGateway {
    String createPaymentLink(
            double amount,
            String userName,
            String userEmail,
            String userPhone,
            UUID orderId
    );
    PaymentStatus getPaymentStatus(
            String paymentId
    );
}

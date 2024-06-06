package dev.dhanush.PaymentService.Repository;

import dev.dhanush.PaymentService.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    Payment save(Payment payment);

    Payment findByPaymentGatewayReferenceId(String paymentGatewayReferenceId);
}

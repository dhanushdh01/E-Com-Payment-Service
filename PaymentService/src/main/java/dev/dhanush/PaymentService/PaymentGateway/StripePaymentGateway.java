package dev.dhanush.PaymentService.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import dev.dhanush.PaymentService.DTO.CreatePaymentLinkRequestDTO;
import dev.dhanush.PaymentService.Entity.PaymentStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StripePaymentGateway implements PaymentGateway {

    @Value("${stripe.key.api}")
    private String stripe_key;

    @Override
    public String createPaymentLink(double amount, String userName, String userEmail, String userPhone, UUID orderId) {
        return "";
    }

    @Override
    public PaymentStatus getPaymentStatus(String paymentId) {
        return null;
    }
}
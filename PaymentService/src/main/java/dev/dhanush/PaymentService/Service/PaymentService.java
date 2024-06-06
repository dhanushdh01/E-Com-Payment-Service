package dev.dhanush.PaymentService.Service;


import dev.dhanush.PaymentService.Entity.Payment;
import dev.dhanush.PaymentService.Entity.PaymentGatwayType;
import dev.dhanush.PaymentService.Entity.PaymentStatus;
import dev.dhanush.PaymentService.PaymentGateway.PaymentGateway;
import dev.dhanush.PaymentService.PaymentGateway.PaymentGatwayStrategy;
import dev.dhanush.PaymentService.PaymentGateway.RazorpayPaymentGateway;
import dev.dhanush.PaymentService.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private PaymentGatwayStrategy paymentGatwayStrategy;
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentGatwayStrategy paymentGatwayStrategy, PaymentRepository paymentRepository, RazorpayPaymentGateway razorpayPaymentGateway) {
        this.paymentGatwayStrategy = paymentGatwayStrategy;
        this.paymentRepository = paymentRepository;
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }

    public String createPaymentLink(UUID orderId) {
        // I need to get the details of the order:
        //      - amount

        // Order order = restTemplate.getForObject("", Order.class);
        // Long amount = order.getAmount();
        // String userName = order.getUser().getName();
        // String userMobile = order.getUser().getPhoneNumber();
        // String userEmail = order.getUser().getEmail();

        double amount = 1000.0;
        String userName = "Dhanush S";
        String userMobile = "+91 8825725960";
        String userEmail = "dhanushdh01@gmail.com";

        PaymentGateway paymentGateway = paymentGatwayStrategy.getBestPaymentGateway();

        String paymentLink = paymentGateway.createPaymentLink(
                amount, userName, userEmail, userMobile, orderId
        );

        Payment payment = new Payment();
        payment.setPaymentLink(paymentLink);
        payment.setOrderId(orderId);
        payment.setPaymentGatwayType(PaymentGatwayType.RAZORPAY);
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setAmount(amount);

        paymentRepository.save(payment);

        return paymentLink;

    }

    public PaymentStatus getPaymentStatus(String paymentGatewayPaymentId) {

        Payment payment = paymentRepository.findByPaymentGatewayReferenceId(paymentGatewayPaymentId);
        PaymentGateway paymentGateway = null;

        if (payment.getPaymentGatwayType().equals(PaymentGatwayType.RAZORPAY)) {
            paymentGateway = razorpayPaymentGateway;
        }

        PaymentStatus paymentStatus = paymentGateway.getPaymentStatus(paymentGatewayPaymentId);;

        payment.setPaymentStatus(paymentStatus);

        paymentRepository.save(payment);

        return paymentStatus;
    }
}
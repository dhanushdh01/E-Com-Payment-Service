package dev.dhanush.PaymentService.PaymentGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentGatwayStrategy {

    @Autowired
    private RazorpayPaymentGateway razorpayPaymentGateway;

    @Autowired
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGateway getBestPaymentGateway() {
        //Storing the PaymentGateway List
        String[] paymentList = {"RazorpayPayment","StripePayment"};

        //Now we'll select the payment Gatway by Randomly
        Random randomList = new Random();
        int randomNumber = randomList.nextInt(paymentList.length);
        String list = paymentList[randomNumber];
        if(list.equals("StripePayment"))
            return stripePaymentGateway;
        return razorpayPaymentGateway;
    }
}

package dev.dhanush.PaymentService.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeClientConfig {
    @Value("${stripe.client.key}")
    private String stripeClientKey;

    @Value("${stripe.client.secret}")
    private String stripeClientSecret;

    @Bean
    public RazorpayClient getStripeClient() throws RazorpayException {
        return new RazorpayClient(stripeClientKey,stripeClientSecret);
    }
}

package dev.dhanush.PaymentService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.events.Event;

@RestController
@RequestMapping("/webhooks/razorpay")
public class RazorpayWebhookController {

    @PostMapping()
    public void handleWebhookEvents (Event event){
        System.out.println("Razorpay Webhook Called");
    }
}

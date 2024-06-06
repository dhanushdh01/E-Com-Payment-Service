package dev.dhanush.PaymentService.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.events.Event;

@RestController
@RequestMapping("/webhooks/stripe")
public class StripeWebhookController {

    @PostMapping()
    public void handleWebhookEvents (Event event){
        if(event.equals("payment_link.created")){
            System.out.println("link Created...");
        }else{
            System.out.println("Done");
        }
        System.out.println("Stripe Webhook Called");
    }
}

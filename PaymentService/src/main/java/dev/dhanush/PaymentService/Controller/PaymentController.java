package dev.dhanush.PaymentService.Controller;

import dev.dhanush.PaymentService.DTO.CreatePaymentLinkRequestDTO;
import dev.dhanush.PaymentService.DTO.CreatePaymentLinkResponseDTO;
import dev.dhanush.PaymentService.Entity.PaymentStatus;
import dev.dhanush.PaymentService.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping()
    public CreatePaymentLinkResponseDTO createPaymentLink(@RequestBody CreatePaymentLinkRequestDTO request){
        String redirectURL = this.paymentService.createPaymentLink(request.getOrderId());
        CreatePaymentLinkResponseDTO response = new CreatePaymentLinkResponseDTO();
        response.setUrl(redirectURL);
        return response;
    }

    @GetMapping("/{id}")
    public PaymentStatus checkPaymentStatus(@PathVariable("id") String paymentGatewayPaymentID) {
        return this.paymentService.getPaymentStatus(paymentGatewayPaymentID);
    }
}

/*
User - createOrder() -> OrderService
User - createPaymentLink -> PaymentService
User (Order Details Page) -> checkPaymentStatus() -> PaymentService
PaymentGatway (Webhook) -> PaymentService
 */

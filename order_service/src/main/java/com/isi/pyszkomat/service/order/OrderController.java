package com.isi.pyszkomat.service.order;

import com.isi.pyszkomat.service.order.services.PaymentRequestProducer;
import com.isi.pyszkomat.common.messages.PaymentRequestMessage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {
    private final PaymentRequestProducer paymentRequestProducer;

    @PostMapping("/")
    public String create() {
        paymentRequestProducer.sendMessage(new PaymentRequestMessage("1", 100L, System.currentTimeMillis()));
        return "Order created";
    }
}

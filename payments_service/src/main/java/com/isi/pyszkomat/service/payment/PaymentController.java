package com.isi.pyszkomat.service.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}

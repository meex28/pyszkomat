package com.isi.pyszkomat.service.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @PostMapping("/")
    public String create() {
        return "Order created";
    }
}

package com.example.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping
    public List<String> getAll() {
        return List.of("Payment #1", "Payment #2");
    }
}
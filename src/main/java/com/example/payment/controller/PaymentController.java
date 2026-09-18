package com.example.payment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payment.entity.Payment;
import com.example.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @RequestBody Payment payment) {

        Payment savedPayment =
                paymentService.createPayment(payment);

        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Payment>> getPaymentsByCustomer(
            @PathVariable Long customerId) {

        return ResponseEntity.ok(
                paymentService.getPaymentsByCustomer(customerId)
        );
    }
}

package com.example.payment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {

        payment.setPaymentReference(
                "PAY-" + UUID.randomUUID()
        );

        payment.setStatus("INITIATED");

        payment.setCreatedAt(LocalDateTime.now());

        payment.setUpdatedAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByCustomer(Long customerId) {

        return paymentRepository
                .findTop50ByCustomerIdOrderByCreatedAtDesc(customerId);
    }
}
package com.hotellanka.paymentgateway.controller;
import com.hotellanka.paymentgateway.Entity.PaymentEntity;
import com.hotellanka.paymentgateway.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    public PaymentController(PaymentDetailsRepository paymentDetailsRepository) {
        this.paymentDetailsRepository = paymentDetailsRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPaymentDetails(@RequestBody PaymentEntity paymentDetails) {
        paymentDetailsRepository.save(paymentDetails);
        return ResponseEntity.ok("Payment details saved successfully.");
    }

    @GetMapping("/customer/{cardNumber}")
    public ResponseEntity<?> getCustomerDetails(@PathVariable String cardNumber) {
        List<PaymentEntity> paymentDetailsList = paymentDetailsRepository.findAllByCardNumber(cardNumber);
        if (!paymentDetailsList.isEmpty()) {
            return ResponseEntity.ok(paymentDetailsList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer details not found for card number: " + cardNumber);
        }
    }
}
package io.synapto.payment.adapter.fiserv.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.synapto.payment.adapter.fiserv.dto.PaymentRequest;
import io.synapto.payment.adapter.fiserv.dto.PaymentResponse;
import io.synapto.payment.adapter.fiserv.service.PaymentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping()
    public PaymentResponse payment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.payment(paymentRequest);
    }

}

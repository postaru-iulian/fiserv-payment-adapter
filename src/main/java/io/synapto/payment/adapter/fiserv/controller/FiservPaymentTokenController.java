package io.synapto.payment.adapter.fiserv.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.synapto.payment.adapter.fiserv.dto.CreatePaymentTokenRequest;
import io.synapto.payment.adapter.fiserv.dto.CreatePaymentTokenResponse;
import io.synapto.payment.adapter.fiserv.service.FiservPaymentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fiserv/payment-tokens")
public class FiservPaymentTokenController {

    private final FiservPaymentService service;

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public CreatePaymentTokenResponse createPaymentToken(@RequestBody CreatePaymentTokenRequest request) {
        return service.createPaymentToken(request);
    }

}

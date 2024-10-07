package io.synapto.payment.adapter.fiserv.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.synapto.payment.adapter.fiserv.dto.GeneratePrimaryTransactionRequest;
import io.synapto.payment.adapter.fiserv.dto.GeneratePrimaryTransactionResponse;
import io.synapto.payment.adapter.fiserv.service.FiservPaymentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fiserv/payments")
public class FiservPaymentController {

    private final FiservPaymentService service;

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public GeneratePrimaryTransactionResponse generatePrimaryTransaction(
            @RequestBody GeneratePrimaryTransactionRequest request) {
        return service.generatePrimaryTransaction(request);
    }

}

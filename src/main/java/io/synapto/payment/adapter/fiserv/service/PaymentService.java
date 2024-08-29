package io.synapto.payment.adapter.fiserv.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.synapto.payment.adapter.fiserv.client.dto.ApiKeyResponse;
import io.synapto.payment.adapter.fiserv.client.CardTokenizationServiceClient;
import io.synapto.payment.adapter.fiserv.client.dto.ChargeRequest;
import io.synapto.payment.adapter.fiserv.client.dto.ChargeResponse;
import io.synapto.payment.adapter.fiserv.client.dto.CreateCardTokenRequest;
import io.synapto.payment.adapter.fiserv.client.dto.CreateCardTokenResponse;
import io.synapto.payment.adapter.fiserv.client.EcommerceServiceClient;
import io.synapto.payment.adapter.fiserv.dto.PaymentRequest;
import io.synapto.payment.adapter.fiserv.dto.PaymentResponse;
import io.synapto.payment.adapter.fiserv.service.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final EcommerceServiceClient ecommerceServiceClient;

    private final CardTokenizationServiceClient cardTokenizationServiceClient;

    private final PaymentMapper mapper;

    public PaymentResponse payment(PaymentRequest paymentRequest) {
        ApiKeyResponse apiKeyResponse = ecommerceServiceClient.retrieveApiKey();

        CreateCardTokenRequest createCardTokenRequest = mapper.toCardDetailsRequest(paymentRequest);

        CreateCardTokenResponse createCardTokenResponse = cardTokenizationServiceClient.createCardToken(
                createCardTokenRequest, apiKeyResponse.apiAccessKey());

        ChargeRequest chargeRequest = ChargeRequest.builder()
                .amount(paymentRequest.amount())
                .currency(paymentRequest.currency())
                .source(createCardTokenResponse.id())
                .build();

        String idempotencyKey = UUID.randomUUID().toString();

        ChargeResponse chargeResponse = ecommerceServiceClient.charge(
                chargeRequest, paymentRequest.clientIp(), idempotencyKey);

        return mapper.toPaymentResponse(chargeResponse);

    }
}

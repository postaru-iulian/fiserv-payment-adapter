package io.synapto.payment.adapter.fiserv.client.dto;

public record PaymentProcessor(
        String referenceNumber,
        String authorizationCode,
        String responseCode,
        String responseMessage
) {
}

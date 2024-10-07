package io.synapto.payment.adapter.fiserv.client.dto;

public record PaymentCardPaymentTokenizationRequest(
        String requestType,
        PaymentCard paymentCard,
        CreateToken createToken,
        Boolean accountVerification
) {
}

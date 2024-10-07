package io.synapto.payment.adapter.fiserv.client.dto;

public record PaymentCardPaymentTokenizationResponse(
        String type,
        String clientRequestId,
        String apiTraceId,
        String requestStatus,
        String requestTime,
        String country,
        PaymentToken paymentToken,
        String orderId,
        String ipgTransactionId
) {
}

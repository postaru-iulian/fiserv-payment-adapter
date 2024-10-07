package io.synapto.payment.adapter.fiserv.dto;

import io.synapto.payment.adapter.fiserv.client.dto.PaymentToken;

public record CreatePaymentTokenResponse(
        String clientRequestId,
        String apiTraceId,
        PaymentToken paymentToken,
        String orderId,
        String ipgTransactionId
) {
}

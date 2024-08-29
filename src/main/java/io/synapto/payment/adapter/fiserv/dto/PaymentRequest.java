package io.synapto.payment.adapter.fiserv.dto;

public record PaymentRequest(
        Long amount,
        String currency,
        String clientIp,
        CardRequest card) {
}

package io.synapto.payment.adapter.fiserv.dto;

public record PaymentResponse(
        String id,
        Long amount,
        String currency,
        Boolean paid,
        String status) {
}

package io.synapto.payment.adapter.fiserv.client.dto;

public record PaymentToken(
        String value,
        Boolean reusable,
        Boolean declineDuplicates,
        String last4,
        String brand,
        String type
) {
}

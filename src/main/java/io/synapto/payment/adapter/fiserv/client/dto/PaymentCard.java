package io.synapto.payment.adapter.fiserv.client.dto;

public record PaymentCard(
        String number,
        ExpiryDate expiryDate,
        String securityCode,
        String bin,
        String last4,
        String brand
) {
}

package io.synapto.payment.adapter.fiserv.client.dto;

public record PaymentMethodDetails(
        PaymentCard paymentCard,
        String paymentMethodType,
        String paymentMethodBrand
) {
}

package io.synapto.payment.adapter.fiserv.dto;

public record CreatePaymentTokenRequest(
        CardRequest card,
        Boolean reusable,
        Boolean declineDuplicates,
        Boolean accountVerification
) {
}

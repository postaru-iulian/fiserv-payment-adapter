package io.synapto.payment.adapter.fiserv.dto;

public record GeneratePrimaryTransactionRequest(
        Double amount,
        String currency,
        String merchantTransactionId,
        CardRequest card
) {
}

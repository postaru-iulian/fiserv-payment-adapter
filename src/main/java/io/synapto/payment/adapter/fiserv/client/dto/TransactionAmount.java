package io.synapto.payment.adapter.fiserv.client.dto;

public record TransactionAmount(
        Double total,
        String currency
) {
}

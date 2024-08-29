package io.synapto.payment.adapter.fiserv.client.dto;

public record CardDetailsResponse(
        String exp_month,
        String exp_year,
        String last4,
        String first6,
        String brand) {
}

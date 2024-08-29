package io.synapto.payment.adapter.fiserv.client.dto;

public record CreateCardTokenRequest(
        CardDetailsRequest card) {
}

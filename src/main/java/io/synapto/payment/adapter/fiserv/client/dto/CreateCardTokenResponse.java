package io.synapto.payment.adapter.fiserv.client.dto;

public record CreateCardTokenResponse(
        String id,
        String object,
        CardDetailsResponse card) {
}

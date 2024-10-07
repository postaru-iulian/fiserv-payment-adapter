package io.synapto.payment.adapter.fiserv.client.dto;

public record CreateToken(
        Boolean reusable,
        Boolean declineDuplicates
) {
}

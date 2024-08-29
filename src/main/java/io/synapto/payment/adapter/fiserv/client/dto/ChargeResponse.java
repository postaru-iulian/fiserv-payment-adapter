package io.synapto.payment.adapter.fiserv.client.dto;

import java.time.Instant;

public record ChargeResponse(
        String id,
        Long amount,
        String payment_method_details,
        Long amount_refunded,
        String currency,
        Instant created,
        Boolean captured,
        Long ref_num,
        Long auth_code,
        ChargeOutcome outcome,
        Boolean paid,
        String status,
        CardDetailsResponse source,
        String ecomind) {
}

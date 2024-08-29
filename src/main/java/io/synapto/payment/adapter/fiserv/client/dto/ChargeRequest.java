package io.synapto.payment.adapter.fiserv.client.dto;

import lombok.Builder;

@Builder
public record ChargeRequest(
        Long amount,
        String currency,
        Boolean capture,
        Boolean partial_redemption,
        String description,
        String ecomind,
        String external_reference_id,
        String external_customer_reference,
        String receipt_email,
        String source,
        String tax_rate_uuid,
        Long tax_amount,
        Long tip_amount) {
}
